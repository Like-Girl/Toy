package cn.likegirl.design.factory.ioc;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: BeanFactory
 * @description: TODO
 * @date 2019/3/1 15:35
 */
public interface BeanFactory {

    Object getBean(Class<?> clazz);

    Object getBean(String name);
}
