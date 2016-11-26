package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@RunWith(AndroidJUnit4.class)
public class FetchJokesTest {
    CountDownLatch signal = null;
    String jokeString = "";

    @Before
    public void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @After
    public void tearDown() throws Exception {
        signal.countDown();
    }

    @Test
    public void testJokesAreFetchedSuccessfully() throws Exception {
        FetchJokes fetchJokes = new FetchJokes(new JokesCallback() {
            @Override
            public void onSuccess(String joke) {
                jokeString = joke;
                signal.countDown();
            }
        });
        fetchJokes.execute();
        signal.await();
        assertThat(jokeString,is(not("")));
    }
}