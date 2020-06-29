package ru.gnupunk.client.core;

import org.springframework.stereotype.Component;

@Component
public interface Core {
    void init();
    void checkState();
}
