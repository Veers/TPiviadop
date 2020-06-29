package ru.gnupunk.client.core.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import ru.gnupunk.client.core.Core;

import javax.annotation.PostConstruct;

@Service("CoreService")
@Scope("singleton")
public class CoreImpl implements Core, ApplicationListener<ContextRefreshedEvent> {;

    @Override
    public void init() {
        System.out.println("init");
    }

    @Override
    public void checkState() {
        System.out.println("check state");
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        this.init();
    }
}
