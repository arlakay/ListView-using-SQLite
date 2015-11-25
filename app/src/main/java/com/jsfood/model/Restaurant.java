package com.jsfood.model;

public class Restaurant {
	private String Id       = "";
    private String Categori = "";
	private String Name     = "";
	private String Address  = "";
	private String Detail   = "";
	private String Pic 	    = "";

	// constructor tanpa parameter
    public Restaurant() {
    
    }
	
	// constructor dengan parameter
    public Restaurant(String Categori, String Name, String Address, String Detail, String Pic){
        this.Categori = Categori;
        this.Name     = Name;
        this.Address  = Address;
        this.Detail   = Detail;
        this.Pic      = Pic;
    }
	

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getId() {
		return Id;
	}

    public void setCategori(String Categori) {
        this.Id = Categori;
    }

    public String getCategori() {
        return Categori;
    }

	public void setName(String Name) {
		this.Name = Name;
	}

	public String getName() {
		return Name;
	}

	public void setAddress(String Address) {
		this.Address = Address;
	}

	public String getAddress() {
		return Address;
	}

	public void setDetail(String Detail) {
		this.Detail = Detail;
	}

	public String getDetail() {
		return Detail;
	}

	public void setPic(String Pic) {
		this.Pic = Pic;
	}

	public String getPic() {
		return Pic;
	}
	
	@Override
	public String toString() {
		return "Id: " + getId() + 
		   	   "; Name: " + getName() +
			   "; Address: " + getAddress() +
			   "; Pic: " + getPic();
	}
}