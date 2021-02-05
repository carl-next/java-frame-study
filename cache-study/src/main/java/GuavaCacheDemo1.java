import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangtao
 * @Title: GuavaCacheDemo1
 * @Package: PACKAGE_NAME
 * @Description: GuavaCacheDemo1[加载方式一]
 * @date 2020-12-21 20:36
 */

public class GuavaCacheDemo1 {
    public static void main(String[] args) {

        //1- 提供缓存加载器
        CacheLoader<String,String> cacheLoader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                    Thread.sleep(100);
                    if("key".equals(key)){
                        return null;
                    }
                    System.out.println(key+" is loaded from a cacheloder!");
                    return key + "`s value";
            }
        };

        //2- 移除监听器
        RemovalListener<String,String> removalListener=new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> removalNotification) {
                System.out.println("["+removalNotification.getKey()+":"+removalNotification.getValue()+"] is evicted!");
            }
        };

        //3- 构建loadingcache
        LoadingCache<String,String> loadingCache= CacheBuilder.newBuilder()
                //缓存容量
                .maximumSize(10)
                //缓存失效时间
                .expireAfterWrite(10, TimeUnit.MINUTES)
                //提供移除监听器
                .removalListener(removalListener)
                //提供缓存加载器
                .build(cacheLoader);


        for(int i=0;i<20;i++){
            String key="key-"+i;
            String value="value-"+i;
            loadingCache.put(key,value);
            System.out.println("[key:"+key+" value:"+value+"] put into cache!");
        }

        // 如果存在就获取 否则返回null
        System.out.println(loadingCache.getIfPresent("key"));
        System.out.println(loadingCache.getIfPresent("key-11"));
    }
}
