package com.wdxxl.jsoup.crawler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.wdxxl.tangpoetry.model.Poetry;
import com.wdxxl.tangpoetry.model.TangPoetry;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlerTangPoetry {
    public static CrawlerTangPoetry tangPoetry = new CrawlerTangPoetry();

    public static void main(String[] args) {
        String url = "http://www.diyifanwen.com/sicijianshang/tangshisanbaishou/index.html";

        List<Poetry> poetries = tangPoetry.crawlerAllPoetry(url);
        TangPoetry tangPoetry = new TangPoetry();
        tangPoetry.setPoetries(poetries);
        try {
            File file = new File("content/tang-poetry.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(TangPoetry.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(tangPoetry, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public List<Poetry> crawlerAllPoetry(String url) {
        Document doc = CrawlerTangPoetry.getDocument(url);
        Elements allContent = doc.select("[class=IndexDl]");
        Elements allPoetry = allContent.select("dd");

        List<Poetry> returnPoetries = new ArrayList<>();
        for (int i = 0; i < allPoetry.size(); i++) {
            Elements link = allPoetry.get(i).select("a");
            Poetry poetry = new Poetry();
            poetry.setId(i + 1);
            poetry.setCategory(CategoryMap.getCatagoryMap(i + 1));
            poetry.setTitle(link.get(0).childNode(0).toString().trim());
            poetry.setAuthor(allPoetry.get(i).text().split("：")[0].trim());
            tangPoetry.crawlerContent(poetry, link.attr("abs:href"));

            returnPoetries.add(poetry);
        }
        return returnPoetries;
    }

    public void crawlerContent(Poetry poetry, String url) {
        Document doc = CrawlerTangPoetry.getDocument(url);
        Elements artContent = doc.select("[id=ArtContent]");
        Elements artPoetryContent = artContent.select("p");
        if (artPoetryContent.size() > 1) {
            convertStringToObject(poetry, artPoetryContent.text().toString());
        } else {
            convertStringToObject(poetry, artPoetryContent.get(0).text().toString());
        }
    }

    private static void convertStringToObject(Poetry poetry, String all) {
        String content = all.substring(0, all.indexOf("【注解】")).trim();
        String notes = all.substring(all.indexOf("【注解】"), all.indexOf("【韵译】") - 1).trim();
        String translate = all.substring(all.indexOf("【韵译】"), all.indexOf("【评析】") - 1).trim();
        String description = all.substring(all.indexOf("【评析】"), all.length()).trim();

        String contentRemoveTitle =
                content.substring(content.indexOf(" "), content.length()).trim();
        String contentRemoveAuthor = contentRemoveTitle
                .substring(contentRemoveTitle.indexOf(" "), contentRemoveTitle.length()).trim();
        poetry.setContent(contentRemoveAuthor);
        poetry.setNotes(notes);
        poetry.setTranslate(translate);
        poetry.setDescription(description);
    }

    private static Document getDocument(String url) {
        try {
            return Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
