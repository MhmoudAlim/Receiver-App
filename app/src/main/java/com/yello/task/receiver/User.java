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
    private String username;
    private String company_name;
    private String name;
    private String email;
    private Integer id;
    private Date updated;
    private String phone;
    private String website;
    private String address_city;
    private String ownerId;
    private String address_street;
    public String getObjectId()
    {
        return objectId;
    }

    public Date getCreated()
    {
        return created;
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

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
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