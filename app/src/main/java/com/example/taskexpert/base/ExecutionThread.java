package com.example.taskexpert.base;

import io.reactivex.Scheduler;

public interface ExecutionThread {
    Scheduler getIOThread();
    Scheduler getMainThread();
    Scheduler getNewThread();

}
