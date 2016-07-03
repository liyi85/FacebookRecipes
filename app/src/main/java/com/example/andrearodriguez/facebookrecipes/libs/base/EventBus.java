package com.example.andrearodriguez.facebookrecipes.libs.base;

/**
 * Created by andrearodriguez on 6/23/16.
 */
public interface EventBus {
    void register(Object subscriber);
    void unregister(Object subscriber);
    void post(Object event);
}
