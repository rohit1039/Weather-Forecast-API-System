# Location API

<a name="addLocation"></a>
# **addLocation**
> addLocation(@RequestBody Location locationRequest)

Adds a location

Persists location information (JSON) into database

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Location** | **Object** | add a location | do not specify value for code field
 
<a name="deleteLocation"></a>
# **deleteLocation**
> deleteLocation(@PathVariable String code)

Deletes a location by code (soft delete)

Trash information of a location found by a given identifier

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **code** | **String**| location code of the location to be trashed | soft delete
 
<a name="getLocations"></a>
# **getLocations**
> getLocations()

Returns information of all locations

Returns a JSON document containing a list of Location objects 

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Location** | **ArrayList**| fetch all locations |
 
<a name="updateLocation"></a>
# **updateLocation**
> updateLocation(@RequestBody Location updateLocation)

Updates a location

Updates information of an existing location

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Location** | **Object**| location to be updated | location code cannot be updated
 
