<a name="addLocation"></a>
# **addLocation**
> addLocation(@RequestBody Location locationRequest)

Adds a location

Persists location information (JSON) into database

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **Location** | **Object** | representation of a location (do not specify value for code field) |
 
<a name="deleteLocation"></a>
# **deleteLocation**
> deleteLocation(code)

Deletes a location by code (soft delete)

Trash information of a location found by a given identifier
