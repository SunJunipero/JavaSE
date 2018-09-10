package readwritelock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriterList <T> {
    private List<T> coreList = new ArrayList<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public ReadWriterList(List<T> list) {
        coreList.addAll(list);
    }

    public ReadWriterList(T[] array) {
        coreList.addAll(Arrays.asList(array));
    }

    public void add(T item){
        Lock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            coreList.add(item);
        }
        finally {
            writeLock.unlock();
        }
    }

    public T get(int index){
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return coreList.get(index);
        }
        finally {
            readLock.unlock();
        }
    }

    public int size(){
        Lock readLock = lock.readLock();
        readLock.lock();
        try {
            return coreList.size();
        }
        finally {
            readLock.unlock();
        }
    }

}
