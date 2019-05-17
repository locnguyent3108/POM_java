package testData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.json.JsonParseException;

import java.io.File;
import java.io.IOException;

//get data from data json
public class customerDataJson {
 public static CustomerDataJson get(String filename) throws JsonParseException, JsonMappingException, IOException{
  ObjectMapper mapper = new ObjectMapper();
  return mapper.readValue(new File(filename), customerDataJson.class);
 }

 @JsonProperty("firstname")
 String firstName;

 @JsonProperty("lastname")
 String lastName;
}
