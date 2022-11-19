package com.fly.ayudaconfiable.network.net.http.response;

import java.util.List;

/**
 * nakesoft
 * Created by 孔明 on 2019年7月10日,0010.
 * 158045632@qq.com
 */
public class AuthorizeBean {
    /**
     * model : {"SystemType":3,"InterfaceKey":"06898b67","InterfaceUrl":"https://kddapi.vip9158.com/api/GeneralInterface/","CompType":2,"AgentTag":"nake"}
     * list : [{"CompCode":"huahua1","VersionName":"美业版","InterfaceUrl":"https://kddapi.vip9158.com/api/GeneralInterface/","InterfaceKey":"3aa4c6e2"},{"CompCode":"test0315","VersionName":"纳客测试专用版","InterfaceUrl":"https://kddapi.vip9158.com/api/GeneralInterface/","InterfaceKey":"32e9bb0c"}]
     */

    private ModelBean model;
    private List<ListBean> list;

    public ModelBean getModel() {
        return model;
    }

    public void setModel(ModelBean model) {
        this.model = model;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ModelBean {
        /**
         * SystemType : 3
         * InterfaceKey : 06898b67
         * InterfaceUrl : https://kddapi.vip9158.com/api/GeneralInterface/
         * CompType : 2
         * AgentTag : nake
         */

        private int SystemType;
        private String InterfaceKey;
        private String InterfaceUrl;
        private int CompType;
        private String AgentTag;

        public int getSystemType() {
            return SystemType;
        }

        public void setSystemType(int SystemType) {
            this.SystemType = SystemType;
        }

        public String getInterfaceKey() {
            return InterfaceKey;
        }

        public void setInterfaceKey(String InterfaceKey) {
            this.InterfaceKey = InterfaceKey;
        }

        public String getInterfaceUrl() {
            return InterfaceUrl;
        }

        public void setInterfaceUrl(String InterfaceUrl) {
            this.InterfaceUrl = InterfaceUrl;
        }

        public int getCompType() {
            return CompType;
        }

        public void setCompType(int CompType) {
            this.CompType = CompType;
        }

        public String getAgentTag() {
            return AgentTag;
        }

        public void setAgentTag(String AgentTag) {
            this.AgentTag = AgentTag;
        }
    }

    public static class ListBean {
        /**
         * CompCode : huahua1
         * VersionName : 美业版
         * InterfaceUrl : https://kddapi.vip9158.com/api/GeneralInterface/
         * InterfaceKey : 3aa4c6e2
         */
        public boolean isSelected = false;
        public boolean isLastItem = false;

        private String CompCode;
        private String VersionName;
        private String InterfaceUrl;
        private String InterfaceKey;

        public String getCompCode() {
            return CompCode;
        }

        public void setCompCode(String CompCode) {
            this.CompCode = CompCode;
        }

        public String getVersionName() {
            return VersionName;
        }

        public void setVersionName(String VersionName) {
            this.VersionName = VersionName;
        }

        public String getInterfaceUrl() {
            return InterfaceUrl;
        }

        public void setInterfaceUrl(String InterfaceUrl) {
            this.InterfaceUrl = InterfaceUrl;
        }

        public String getInterfaceKey() {
            return InterfaceKey;
        }

        public void setInterfaceKey(String InterfaceKey) {
            this.InterfaceKey = InterfaceKey;
        }
    }
}
