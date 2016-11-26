package com.abhinandankothari.jokes;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class JokesClientTest {

    @Test
    public void jokeIsDisplayed() throws Exception {
        JokesClient jokesClient = new JokesClient();
        String joke = jokesClient.joke();
        assertThat("Are you Kiddin! Me?",is(joke));

    }
}