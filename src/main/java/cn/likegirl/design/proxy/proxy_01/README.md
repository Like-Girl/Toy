
静态代理

一 场景：记录Tank 移动时间

实现：  
1. 聚合  
    TankTimeProxy 实现Moveable 接口代理计算移动时长
2. 继承  
    TankTimeExtendProxy 继承Tank 重写move() 代理计算移动时长


二 场景：先记录日志，再计算Tank 移动时间  

实现：  
1. 聚合  
    TankTimeProxy 实现Moveable 接口代理计算移动时长，  
    TankLogProxy 实现Moveable 接口代理记录，  
    代理过程： TankLogProxy -》 TankTimeProxy -》 Tank
2. 继承  
    TankTimeExtendProxy 继承Tank 重写move() 接口代理计算移动时长，  
    TankLogAndTimeExtendProxy 继承TankTimeExtendProxy重写move() 代理记录日志，  
    代理过程： TankLogAndTimeExtendProxy  

三 场景：先计算Tank 移动时间，再记录日志 

实现：  
1. 聚合  
    在场景二的基础上，将代理过程调整一下就可以完成，  
    代理过程： TankTimeProxy -》 TankLogProxy -》 Tank
2. 继承  
    TankLogExtendProxy 继承Tank 重写move() 代理记录日志，  
    TankTimeAndLogExtendProxy 继承TankLogExtendProxy重写move() 代理记录日志，  
    代理过程： TankTimeAndLogExtendProxy
    
由场景二和场景三，可见动态（静态）代理两种实现方式中，聚合（接口实现）的灵活性要远远高于继承。
计算运行时长、记录日志，在聚合的实现方式中，不管业务是怎么组合，我们只要把代理过程调整一下就可以
办到。到在继承的实现方式中，我们需要按照业务的组合顺序，依次继承实现，跟着业务组合的变化还得重新
继承实现。


