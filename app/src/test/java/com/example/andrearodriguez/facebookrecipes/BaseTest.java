package com.example.andrearodriguez.facebookrecipes;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowApplication;

/**
 * Created by andrearodriguez on 7/20/16.
 */
public abstract class BaseTest {

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        if (RuntimeEnvironment.application != null){
            ShadowApplication shadowApp = Shadows.shadowOf(RuntimeEnvironment.application);
            shadowApp.grantPermissions("android.permission.INTERNET");
        }
    }
}
