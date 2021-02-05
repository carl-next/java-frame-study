# 执行 thrift -r -gen java ./demo.thrift
namespace java thrift

service  UserService {
  string getName(1:i32 id)
  bool isExist(1:string name)
  string sayHello(1:string name)
}