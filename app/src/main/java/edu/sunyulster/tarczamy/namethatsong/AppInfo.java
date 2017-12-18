package edu.sunyulster.tarczamy.namethatsong;

import java.io.Serializable;

public abstract class AppInfo implements Serializable{

    public String getApiKey(){
        return "OTM4Nzg2NjMtZmM1Ni00ZDk0LWFkOGMtMDU3MjdiZjZmMjhk";
    }

    public String getSecret() {
        return "MjA0YWFjOWEtMzM1Yy00ZjY2LWExNzktMjQ5YjMxY2I4YzNl";
    }

    public String getRedirectUrl() {
        return "Name That Song App";
    }

}
