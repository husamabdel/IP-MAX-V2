import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * 
 * ip                   : 8.8.8.8
version              : IPv4
city                 : Mountain View
region               : California
region_code          : CA
country              : US
country_name         : United States
country_code         : US
country_code_iso3    : USA
country_capital      : Washington
country_tld          : .us
continent_code       : NA
in_eu                : False
postal               : 94043
latitude             : 37.42301
longitude            : -122.083352
timezone             : America/Los_Angeles
utc_offset           : -0700
country_calling_code : +1
currency             : USD
currency_name        : Dollar
languages            : en-US,es-US,haw,fr
country_area         : 9629091
country_population   : 327167434
asn                  : AS15169
org                  : GOOGLE

 * 
 * */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ipObject {

	public String ip;
	public String version;
	public String city;
	public String region;
	public String region_code;
	public String country;
	public String country_name;
	public String country_code;
	public String country_code_iso3;
	public String country_capital;
	public String country_tld;
	public String continent_code;
	public String in_eu;
	public String postal;
	public String latitude;
	public String longitude;
	public String timezone;
	public String utc_offset;
	public String country_calling_code;
	public String currency;
	public String currency_name;
	public String languages;
	public String country_area;
	public String country_population;
	public String asn;
	public String org;

	public ipObject() {
		
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	public String getIp() {
		return ip;
	}











	public String getVersion() {
		return version;
	}











	public String getCity() {
		return city;
	}











	public String getRegion() {
		return region;
	}











	public String getRegion_code() {
		return region_code;
	}











	public String getCountry() {
		return country;
	}











	public String getCountry_name() {
		return country_name;
	}











	public String getCountry_code() {
		return country_code;
	}











	public String getCountry_code_iso3() {
		return country_code_iso3;
	}











	public String getCountry_capital() {
		return country_capital;
	}











	public String getCountry_tld() {
		return country_tld;
	}











	public String getContinent_code() {
		return continent_code;
	}











	public String getIn_eu() {
		return in_eu;
	}











	public String getPostal() {
		return postal;
	}











	public String getLatitude() {
		return latitude;
	}











	public String getLongitude() {
		return longitude;
	}











	public String getTimezone() {
		return timezone;
	}











	public String getUtc_offset() {
		return utc_offset;
	}











	public String getCountry_calling_code() {
		return country_calling_code;
	}











	public String getCurrency() {
		return currency;
	}











	public String getCurrency_name() {
		return currency_name;
	}











	public String getLanguages() {
		return languages;
	}











	public String getCountry_area() {
		return country_area;
	}











	public String getCountry_population() {
		return country_population;
	}











	public String getAsn() {
		return asn;
	}











	public String getOrg() {
		return org;
	}











	public String GetObjectValue() {
		
		String vals =
				
				
				 ip+"\n"+                   
				 version+              
				 city       +          "\n"+   
				 region      +         "\n"+   
				 region_code  +        "\n"+   
				 country       +       "\n"+   
				 country_name   +      "\n"+   
				 country_code    +     "\n"+   
				 country_code_iso3+    "\n"+   
				 country_capital   +   "\n"+   
				 country_tld        +  "\n"+   
				 continent_code      + "\n"+   
				 in_eu                +"\n"+   
				 postal               +"\n"+
				 latitude             +"\n"+   
				 longitude            +"\n"+   
				 timezone             +"\n"+   
				 utc_offset           +"\n"+   
				 country_calling_code +"\n"+   
				 currency             +"\n"+   
				 currency_name      +"\n"+   
				 languages           +"\n"+   
				 country_area        +"\n"+   
				 country_population   +"\n"+   
				 asn                  +"\n"+   
				 org                  
				
				
				; return vals;
		
	}
	
}
