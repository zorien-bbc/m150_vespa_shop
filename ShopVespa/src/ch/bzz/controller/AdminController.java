package ch.bzz.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import ch.bzz.model.Bild;
import ch.bzz.model.Kategorie;
import ch.bzz.model.Produkt;
import ch.bzz.model.Tag;
import ch.bzz.service.IndexService;
import ch.bzz.service.ProduktService;

@ViewScoped
@ManagedBean
public class AdminController {

	private List<Produkt> lager;
	private Produkt produkt;
	private String kat;
	private List<String> kategorien;
	private List<Part> bilder;
	private OutputStream outputStream;
	private static final String RootPath ="C:/glassfish-4.1.2/glassfish4/glassfish/domains/domain1/docroot/resources/images";

	@EJB
	private ProduktService produktservice;

	@EJB
	private IndexService indexService;

	@PostConstruct
	public void init() {
		lager = produktservice.collectAll();
		produkt = new Produkt();
		produkt.setBilds(new ArrayList<Bild>());
		kategorien = new ArrayList<String>();
		for (Kategorie k : indexService.collectKategorien()) {
			kategorien.add(k.getName());
		}

	}

	public String addProdukt() {
		Tag tag = new Tag();
		tag.setName("test");
		produkt.setKategorie(produktservice.find(kat));
		Produkt prod = lager.get(lager.size()-1);
		savePictures(prod.getIdProdukt());
		produktservice.addProdukt(produkt);
		produkt = new Produkt();
		produkt.setBilds(new ArrayList<Bild>());
		lager = produktservice.collectAll();
		return null;
	}
	
	private void savePictures(int id){
		int number = 0;
		id++;
		for(Part part : bilder){
			try {
				InputStream inputStream = part.getInputStream();
				String finalPath = RootPath+"/"+id+"_"+number+".png";
				Bild bild = new Bild();
				bild.setPfad("/resources/images/"+id+"_"+number+".png");
				bild.setProdukt(produkt);
				produkt.addBild(bild);
				outputStream = new FileOutputStream(new File(finalPath));
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = inputStream.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			number++;
		}
	}

	public List<Produkt> getLager() {
		return lager;
	}

	public void setLager(List<Produkt> lager) {
		this.lager = lager;
	}

	public Produkt getProdukt() {
		return produkt;
	}

	public void setProdukt(Produkt produkt) {
		this.produkt = produkt;
	}

	public String getKat() {
		return kat;
	}

	public void setKat(String kat) {
		this.kat = kat;
	}

	public List<String> getKategorien() {
		return kategorien;
	}

	public void setKategorien(List<String> kategorien) {
		this.kategorien = kategorien;
	}

	public List<Part> getBilder() {
		return bilder;
	}

	public void setBilder(List<Part> bilder) {
		this.bilder = bilder;
	}
}
