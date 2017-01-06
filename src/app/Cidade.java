package app;

public class Cidade {

	String ibge_id, uf, name, capital, lon, lat, no_accents, alternative_names, micro_region, mesoregion;
	
	public Cidade(String ibge_id, String uf, String name, String capital, String lon, String lat, String no_accents, String alternative_names, String micro_region, String mesoregion){
		this.ibge_id = ibge_id;
		this.uf = uf;
		this.name = name;
		this.capital = capital;
		this.lon = lon;
		this.lat = lat;
		this.no_accents = no_accents;
		this.alternative_names = alternative_names;
		this.micro_region = micro_region;
		this.mesoregion = mesoregion;
	}
	
	public String retornaVar(String filtro){
		switch(filtro){
			case "ibge_id":
				return this.ibge_id;
			
			case "uf":
				return this.uf;
			
			case "name":
				return this.name;
			
			case "capital":
				return this.capital;
			
			case "lon":
				return this.lon;
			
			case "lat":
				return this.lat;
			
			case "no_accents":
				return this.no_accents;
			
			case "alternative_names":
				return this.alternative_names;
			
			case "micro_region":
				return this.micro_region;
	
			case "mesoregion":
				return this.mesoregion;
		}
		return null;
	}

	@Override
	public String toString(){
		return ibge_id +","+uf+","+name+","
				+capital+","+lon+","+lat+","+no_accents+","+alternative_names
				+","+micro_region+","+mesoregion;
	}
}
