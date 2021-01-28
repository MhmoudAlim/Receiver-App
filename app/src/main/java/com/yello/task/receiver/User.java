package com.yello.task.receiver;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.*;
import com.backendless.geo.GeoPoint;

import java.util.List;
import java.util.Date;

public class User
{
    private String objectId;
    private Date created;
    private String geo_lng;
    private String username;
    private String company_name;
    private String name;
    private String company_bs;
    private String email;
    private String address_zipcode;
    private Integer id;
    private Date updated;
    private String company_catchPhrase;
    private String geo_lat;
    private String phone;
    private String website;
    private String address_city;
    private String ownerId;
    private String address_suite;
    private String address_street;
    public String getObjectId()
    {
        return objectId;
    }

    public Date getCreated()
    {
        return created;
    }

    public String getGeo_lng()
    {
        return geo_lng;
    }

    public void setGeo_lng( String geo_lng )
    {
        this.geo_lng = geo_lng;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername( String username )
    {
        this.username = username;
    }

    public String getCompany_name()
    {
        return company_name;
    }

    public void setCompany_name( String company_name )
    {
        this.company_name = company_name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getCompany_bs()
    {
        return company_bs;
    }

    public void setCompany_bs( String company_bs )
    {
        this.company_bs = company_bs;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }

    public String getAddress_zipcode()
    {
        return address_zipcode;
    }

    public void setAddress_zipcode( String address_zipcode )
    {
        this.address_zipcode = address_zipcode;
    }

    public Integer getId()
    {
        return id;
    }

    public void setId( Integer id )
    {
        this.id = id;
    }

    public Date getUpdated()
    {
        return updated;
    }

    public String getCompany_catchPhrase()
    {
        return company_catchPhrase;
    }

    public void setCompany_catchPhrase( String company_catchPhrase )
    {
        this.company_catchPhrase = company_catchPhrase;
    }

    public String getGeo_lat()
    {
        return geo_lat;
    }

    public void setGeo_lat( String geo_lat )
    {
        this.geo_lat = geo_lat;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone( String phone )
    {
        this.phone = phone;
    }

    public String getWebsite()
    {
        return website;
    }

    public void setWebsite( String website )
    {
        this.website = website;
    }

    public String getAddress_city()
    {
        return address_city;
    }

    public void setAddress_city( String address_city )
    {
        this.address_city = address_city;
    }

    public String getOwnerId()
    {
        return ownerId;
    }

    public String getAddress_suite()
    {
        return address_suite;
    }

    public void setAddress_suite( String address_suite )
    {
        this.address_suite = address_suite;
    }

    public String getAddress_street()
    {
        return address_street;
    }

    public void setAddress_street( String address_street )
    {
        this.address_street = address_street;
    }


    public User save()
    {
        return Backendless.Data.of( User.class ).save( this );
    }

    public void saveAsync( AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).save( this, callback );
    }

    public Long remove()
    {
        return Backendless.Data.of( User.class ).remove( this );
    }

    public void removeAsync( AsyncCallback<Long> callback )
    {
        Backendless.Data.of( User.class ).remove( this, callback );
    }

    public static User findById( String id )
    {
        return Backendless.Data.of( User.class ).findById( id );
    }

    public static void findByIdAsync( String id, AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).findById( id, callback );
    }

    public static User findFirst()
    {
        return Backendless.Data.of( User.class ).findFirst();
    }

    public static void findFirstAsync( AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).findFirst( callback );
    }

    public static User findLast()
    {
        return Backendless.Data.of( User.class ).findLast();
    }

    public static void findLastAsync( AsyncCallback<User> callback )
    {
        Backendless.Data.of( User.class ).findLast( callback );
    }

    public static List<User> find( DataQueryBuilder queryBuilder )
    {
        return Backendless.Data.of( User.class ).find( queryBuilder );
    }

    public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<User>> callback )
    {
        Backendless.Data.of( User.class ).find( queryBuilder, callback );
    }
}