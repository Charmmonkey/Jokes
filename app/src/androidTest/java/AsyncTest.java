import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.udacity.gradle.builditbigger.AsyncResponse;
import com.udacity.gradle.builditbigger.JokesAsyncTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotNull;

/**
 * Created by jerye on 4/29/2017.
 */
@RunWith(AndroidJUnit4.class)
public class AsyncTest implements AsyncResponse{
    String testJoke;

    @Override
    public void processFinish(String result) {
        testJoke = result;
        Log.d("Test", testJoke);
        assertNotNull(testJoke);

    }

    @Test
    public void asyncTaskReturnsNonnull() {
        new JokesAsyncTask(this).execute();
    }





}
