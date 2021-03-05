package com.pluralsight.blog.data;

import com.pluralsight.blog.model.Author;
import com.pluralsight.blog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class DatabaseLoader implements ApplicationRunner {
    private final String[] templates = {
            "Smart Home %s", "Mobile %s - For When You're On he Go", "The %s - Your New Favorite Accessory"};
    private final String[] gadgets = {
            "Earbuds", "Speakers", "Tripod", "Instant Pot", "Coffee Cup", "Keyboard", "Sunglasses"};

    private final String[] subTemplates = {
            "This %s is the real deal!", "%s - For anyone.", "The %s - Dangerous or Safe?"};
    private final String[] subGadgets = {
            "Water Bottle", "Toothpick", "Lobster", "Old Fashion Radiator", "Tin Cup", "Antenna", "Boots"};

    public List<Post> randomPosts = new ArrayList<>();
    public List<Author> authors = new ArrayList<>();

    private final PostRepository postRepository;

    @Autowired
    public DatabaseLoader(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        IntStream.range(0,40).forEach(i->{
            String template = templates[i % templates.length];
            String gadget = gadgets[i % gadgets.length];
            String subtitleTemplate = subTemplates[i % subTemplates.length];
            String subtitleGadget = subGadgets[i % subGadgets.length];

            String title = String.format(template, gadget);
            String subtitle = String.format(subtitleTemplate, subtitleGadget);
            Post post = new Post(title, "Lorem ipsum dolor sit amet, consectetur adipiscing elit… ", subtitle);
//            System.out.println(title + ": " + subtitle + "\n" + post.getTitle() + ": " + post.getSubTitle() + "\n\n");
            this.randomPosts.add(post);
        });
        this.postRepository.saveAll(randomPosts);
    }
}
