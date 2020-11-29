package com.gmail.logger2020;

public enum MessageLogs {
    DEBUG("Запись"), WARNING("Предупреждение"), ERROR("Ошибка");

    private String logs;

    private MessageLogs(String logs){
        this.logs = logs;
    }
    public String getLogs(){
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
}
