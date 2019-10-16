package ua.epam.task9.json;

import com.google.gson.*;

import java.lang.reflect.Type;

public class UserConverter implements JsonSerializer<User>, JsonDeserializer<User> {
    @Override
    public JsonElement serialize(User src, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();

        object.addProperty("name", src.getName());
        object.addProperty("surname", src.getSurname());
        object.addProperty("email", src.getEmail());
        object.addProperty("phone", src.getPhone());
        object.add("address", jsonSerializationContext.serialize(src.getAddress()));

        return object;
    }

    @Override
    public User deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();

        String name = object.get("name").getAsString();
        String surname = object.get("surname").getAsString();
        String email = object.get("email").getAsString();
        String phone = object.get("phone").getAsString();
        User.Address address = jsonDeserializationContext.deserialize(object.get("address"), User.Address.class);

        return new User(name, surname, email, phone, address);
    }
}
//class AddressConverter implements JsonSerializer<User.Address>, JsonDeserializer<User.Address> {
//
//    @Override
//    public JsonElement serialize(User.Address address, Type type, JsonSerializationContext jsonSerializationContext) {
//        JsonObject object = new JsonObject();
//
//        object.addProperty("city", address.city);
//        object.addProperty("postcode", address.postcode);
//
//        return object;
//    }
//
//    @Override
//    public User.Address deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
//        JsonObject object = jsonElement.getAsJsonObject();
//
//        String city = object.get("city").getAsString();
//        Integer postcode = object.get("postcode").getAsInt();
//
//        return new User.Address(city, postcode);
//    }
//}