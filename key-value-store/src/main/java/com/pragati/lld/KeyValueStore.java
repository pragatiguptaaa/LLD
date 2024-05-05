package com.pragati.lld;

import java.util.*;

/*
Interviewer asked to design a database and listed ADD, UPDATE, DELETE commands to be expected. Input would be as list of strings.
["ADD key1 value1"]
["UPDATE key1 value2"]
["DELETE key1"]

Follow up: How can we handle transactions? Input can be like, START TRANSACTION
followed by some other inputs which should only be updated in the database when
COMMIT is received and can be rollback in case ROLLBACK is received.
 */

public class KeyValueStore {
    private final Stack<Map<String, String>> localStore;
    private final Map<String, String> globalStore;

    private final String UNDEFINED = "NAN";

    public KeyValueStore() {
        this.localStore = new Stack<>();
        this.globalStore = new HashMap<>();
    }

    public void begin() {
        localStore.push(new HashMap<>());
    }

    public void set(String key, String value) {
        Map<String, String> currentTransaction = null;
        if(!localStore.empty())
            currentTransaction = localStore.peek();
        if (currentTransaction != null) {
            currentTransaction.put(key, value);
        } else {
            globalStore.put(key, (value));
        }
    }

    public String get(String key) {
        Map<String, String> currentTransaction = null;
        if(!localStore.empty())
            currentTransaction = localStore.peek();
        if(currentTransaction!=null && currentTransaction.containsKey(key))
            return currentTransaction.get(key);
        else return globalStore.getOrDefault(key, "No Key Found");
    }

    public void delete(String key) {
        Map<String, String> currentTransaction = null;
        if(!localStore.empty())
            currentTransaction = localStore.peek();
        if (currentTransaction != null) {
            currentTransaction.put(key, UNDEFINED);
        } else {
            globalStore.remove(key);
        }
    }

    public void commit() {
        Map<String, String> currentTransaction = localStore.pop();
        for (Map.Entry<String, String> entry : currentTransaction.entrySet()) {
            if (UNDEFINED.equals(entry.getValue())) {
                globalStore.remove(entry.getKey());

            } else {
                globalStore.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void rollback() {
        localStore.pop();
    }

    public static void main(String[] args) {
        JobScheduler kv = new JobScheduler();
        kv.begin();
        kv.set("test", "hello");
        kv.set("test1", "hello1");
        kv.commit();

        System.out.println(kv.get("test1"));
        kv.begin();
        kv.set("test2", "hello2");
        kv.begin();
        kv.delete("test1");
        kv.commit();
        System.out.println(kv.get("test1"));
        kv.commit();
        kv.set("test2", "hello3");
        kv.begin();
        kv.set("test3", "hello3");
        kv.rollback();
        System.out.println(kv.get("test2"));
        System.out.println(kv.get("test3"));
    }
}