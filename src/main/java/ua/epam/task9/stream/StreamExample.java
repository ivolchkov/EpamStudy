package ua.epam.task9.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        int result = numbers.stream().
                reduce(10, Integer::sum);

        System.out.println(result);

        Artist poll = new Artist("Paul McCartney", "Liverpool");
        Artist lenon = new Artist("John Lennon", "London");
        Artist george = new Artist("George Harrison", "Chelsea");
        Artist ringo = new Artist("Ringo Starr", "British Columbia");
        Band beatles = new Band(Arrays.asList(poll, lenon, george, ringo));

        List<String> singersInfo = beatles.getNames().stream().
                map(artist -> artist.getName() + " : " + artist.getCity()).
                collect(Collectors.toList());

        System.out.println(singersInfo);

//        List<Albums> filtered = albums.stream().
//                filter(album -> album.getSongs() <= 3).
//                collect(Collectors.toList());

//        int totalMembers = beatles.getNames().stream().
//                reduce(0, (acc, members) -> acc + members.count());
    }
}

class Band {
    private List<Artist> names;

    public Band(List<Artist> names) {
        this.names = names;
    }

    public List<Artist> getNames() {
        return names;
    }
}

class Artist {
    private String name;
    private String city;

    public Artist(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}


