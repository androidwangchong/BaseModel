package com.model.basemodel.http.api;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * BaseModel
 * Created by wangchong on 2017/7/14.
 */

public class model implements Serializable {
    private static final long serialVersionUID = 8759298444896320909L;
    /**
     * id : 26096
     * subLemmaId : 7373792
     * newLemmaId : 27263
     * key : 银魂
     * desc : 空知英秋创作的漫画
     * title : 银魂
     * card : [{"key":"m21_bookname","name":"中文名","value":["银魂"],"format":["银魂"]},{"key":"m21_originalname","name":"原版名称","value":["銀魂"],"format":["銀魂"]},{"key":"m21_othername","name":"其他名称","value":["GINTAMA，ぎんたま"],"format":["GINTAMA，ぎんたま"]},{"key":"m21_author","name":"作者","value":["<a target=_blank href=\"/item/%E7%A9%BA%E7%9F%A5%E8%8B%B1%E7%A7%8B\">空知英秋<\/a>"],"format":["<a target=_blank href=\"/item/%E7%A9%BA%E7%9F%A5%E8%8B%B1%E7%A7%8B\">空知英秋<\/a>"]},{"key":"m21_booktype","name":"类型","value":["幕末、搞笑、科幻、动作"],"format":["幕末、搞笑、科幻、动作"]},{"key":"m21_bookregion","name":"地区","value":["日本"],"format":["日本"]},{"key":"m21_seriesmagazine","name":"连载杂志","value":["《<a target=_blank href=\"/item/%E5%91%A8%E5%88%8A%E5%B0%91%E5%B9%B4JUMP\">周刊少年JUMP<\/a>》"],"format":["《<a target=_blank href=\"/item/%E5%91%A8%E5%88%8A%E5%B0%91%E5%B9%B4JUMP\">周刊少年JUMP<\/a>》"]},{"key":"m21_seriesnum","name":"揭载号","value":["2004年2号"],"format":["2004年2号"]},{"key":"m21_seriesperiod","name":"连载期间","value":["2003年12月－连载中"],"format":["2003年12月－连载中"]},{"key":"m21_press","name":"出版社","value":["<a target=_blank href=\"/item/%E9%9B%86%E8%8B%B1%E7%A4%BE\">集英社<\/a>"],"format":["<a target=_blank href=\"/item/%E9%9B%86%E8%8B%B1%E7%A4%BE\">集英社<\/a>"]},{"key":"m21_publishperiod","name":"出版期间","value":["2004年4月－"],"format":["2004年4月－"]},{"key":"m21_volumes","name":"单行本册数","value":["64卷（2016年5月）"],"format":["64卷（2016年5月）"]},{"key":"m21_otherpress","name":"其他出版社","value":["中国台湾：<a target=_blank href=\"/item/%E4%B8%9C%E7%AB%8B%E5%87%BA%E7%89%88%E7%A4%BE\">东立出版社<\/a>","中国香港：<a target=_blank href=\"/item/%E6%AD%A3%E6%96%87%E7%A4%BE\">正文社<\/a>","中国大陆：<a target=_blank href=\"/item/%E8%BF%9E%E7%8E%AF%E7%94%BB%E5%87%BA%E7%89%88%E7%A4%BE\">连环画出版社<\/a>（出版）、北京中少动漫（发行）","新加坡：创艺出版社"],"format":["中国台湾：<a target=_blank href=\"/item/%E4%B8%9C%E7%AB%8B%E5%87%BA%E7%89%88%E7%A4%BE\">东立出版社<\/a>","中国香港：<a target=_blank href=\"/item/%E6%AD%A3%E6%96%87%E7%A4%BE\">正文社<\/a>","中国大陆：<a target=_blank href=\"/item/%E8%BF%9E%E7%8E%AF%E7%94%BB%E5%87%BA%E7%89%88%E7%A4%BE\">连环画出版社<\/a>（出版）、北京中少动漫（发行）","新加坡：创艺出版社"]},{"key":"m21_ext_0","name":"网络连载","value":["<a target=_blank href=\"/item/%E8%85%BE%E8%AE%AF%E5%8A%A8%E6%BC%AB\">腾讯动漫<\/a>（中国大陆）"],"format":["<a target=_blank href=\"/item/%E8%85%BE%E8%AE%AF%E5%8A%A8%E6%BC%AB\">腾讯动漫<\/a>（中国大陆）"]}]
     * image : http://f.hiphotos.baidu.com/baike/pic/item/8d5494eef01f3a295021f8289825bc315d607c6e.jpg
     * src : 8d5494eef01f3a295021f8289825bc315d607c6e
     * imageHeight : 768
     * imageWidth : 512
     * isSummaryPic : y
     * abstract : 《银魂》是由日本漫画家空知英秋创作的少年漫画作品，于2004年2号的《周刊少年Jump》开始连载。2006年4月4日起，由日升动画改编的同名电视动画开始在东京电视台放送。截至2016年7月3日，《银魂》单行本累计发行量突破5000万册。
     * moduleIds : [144301082,144301083,144301084,144301085,144301086,144301087,144301088,144301089,144301090,144301091,144301092,144301093,144301094,144301095,144301096,144301097,144301098]
     * url : http://baike.baidu.com/subview/26096/7373792.htm
     * wapUrl : http://wapbaike.baidu.com/item/%E9%93%B6%E9%AD%82/27263
     * hasOther : 1
     * totalUrl : http://baike.baidu.com/view/26096.htm
     * catalog : ["<a href='http://baike.baidu.com/subview/26096/7373792.htm#1'>创作背景<\/a>","<a href='http://baike.baidu.com/subview/26096/7373792.htm#2'>剧情简介<\/a>","<a href='http://baike.baidu.com/subview/26096/7373792.htm#3'>登场角色<\/a>","<a href='http://baike.baidu.com/subview/26096/7373792.htm#4'>用语解说<\/a>"]
     * wapCatalog : ["<a href='http://wapbaike.baidu.com/item/%E9%93%B6%E9%AD%82/27263#1'>创作背景<\/a>","<a href='http://wapbaike.baidu.com/item/%E9%93%B6%E9%AD%82/27263#2'>剧情简介<\/a>","<a href='http://wapbaike.baidu.com/item/%E9%93%B6%E9%AD%82/27263#3'>登场角色<\/a>","<a href='http://wapbaike.baidu.com/item/%E9%93%B6%E9%AD%82/27263#4'>用语解说<\/a>"]
     * logo : http://img.baidu.com/img/baike/logo-baike.gif
     * copyrights : 以上内容来自百度百科平台，由百度百科网友创作。
     * customImg :
     * redirect : []
     */

    private int id;
    private int subLemmaId;
    private int newLemmaId;
    private String key;
    private String desc;
    private String title;
    private String image;
    private String src;
    private int imageHeight;
    private int imageWidth;
    private String isSummaryPic;
    @SerializedName("abstract")
    private String abstractX;
    private String url;
    private String wapUrl;
    private int hasOther;
    private String totalUrl;
    private String logo;
    private String copyrights;
    private String customImg;
    private List<CardBean> card;
    private List<Integer> moduleIds;
    private List<String> catalog;
    private List<String> wapCatalog;
    private List<?> redirect;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSubLemmaId() {
        return subLemmaId;
    }

    public void setSubLemmaId(int subLemmaId) {
        this.subLemmaId = subLemmaId;
    }

    public int getNewLemmaId() {
        return newLemmaId;
    }

    public void setNewLemmaId(int newLemmaId) {
        this.newLemmaId = newLemmaId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public String getIsSummaryPic() {
        return isSummaryPic;
    }

    public void setIsSummaryPic(String isSummaryPic) {
        this.isSummaryPic = isSummaryPic;
    }

    public String getAbstractX() {
        return abstractX;
    }

    public void setAbstractX(String abstractX) {
        this.abstractX = abstractX;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getWapUrl() {
        return wapUrl;
    }

    public void setWapUrl(String wapUrl) {
        this.wapUrl = wapUrl;
    }

    public int getHasOther() {
        return hasOther;
    }

    public void setHasOther(int hasOther) {
        this.hasOther = hasOther;
    }

    public String getTotalUrl() {
        return totalUrl;
    }

    public void setTotalUrl(String totalUrl) {
        this.totalUrl = totalUrl;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCopyrights() {
        return copyrights;
    }

    public void setCopyrights(String copyrights) {
        this.copyrights = copyrights;
    }

    public String getCustomImg() {
        return customImg;
    }

    public void setCustomImg(String customImg) {
        this.customImg = customImg;
    }

    public List<CardBean> getCard() {
        return card;
    }

    public void setCard(List<CardBean> card) {
        this.card = card;
    }

    public List<Integer> getModuleIds() {
        return moduleIds;
    }

    public void setModuleIds(List<Integer> moduleIds) {
        this.moduleIds = moduleIds;
    }

    public List<String> getCatalog() {
        return catalog;
    }

    public void setCatalog(List<String> catalog) {
        this.catalog = catalog;
    }

    public List<String> getWapCatalog() {
        return wapCatalog;
    }

    public void setWapCatalog(List<String> wapCatalog) {
        this.wapCatalog = wapCatalog;
    }

    public List<?> getRedirect() {
        return redirect;
    }

    public void setRedirect(List<?> redirect) {
        this.redirect = redirect;
    }

    public static class CardBean {
        /**
         * key : m21_bookname
         * name : 中文名
         * value : ["银魂"]
         * format : ["银魂"]
         */

        private String key;
        private String name;
        private List<String> value;
        private List<String> format;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getValue() {
            return value;
        }

        public void setValue(List<String> value) {
            this.value = value;
        }

        public List<String> getFormat() {
            return format;
        }

        public void setFormat(List<String> format) {
            this.format = format;
        }
    }

    @Override
    public String toString() {
        return "model{" +
                "id=" + id +
                ", subLemmaId=" + subLemmaId +
                ", newLemmaId=" + newLemmaId +
                ", key='" + key + '\'' +
                ", desc='" + desc + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", src='" + src + '\'' +
                ", imageHeight=" + imageHeight +
                ", imageWidth=" + imageWidth +
                ", isSummaryPic='" + isSummaryPic + '\'' +
                ", abstractX='" + abstractX + '\'' +
                ", url='" + url + '\'' +
                ", wapUrl='" + wapUrl + '\'' +
                ", hasOther=" + hasOther +
                ", totalUrl='" + totalUrl + '\'' +
                ", logo='" + logo + '\'' +
                ", copyrights='" + copyrights + '\'' +
                ", customImg='" + customImg + '\'' +
                ", card=" + card +
                ", moduleIds=" + moduleIds +
                ", catalog=" + catalog +
                ", wapCatalog=" + wapCatalog +
                ", redirect=" + redirect +
                '}';
    }
}
