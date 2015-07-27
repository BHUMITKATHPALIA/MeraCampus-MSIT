package work.anmol.com.meracampus;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.AboutUsActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.AssesmentActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.ChatActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.NewsAndEventsActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.NotesActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.SocietiesActivity;
import work.anmol.com.meracampus.ContentActivities.NavDrawerActivities.TeacherReviewActivity;


public class DrawerActivity extends AppCompatActivity {

    String TITLES[] = {"About Us", "Chat", "Notes", "Teacher Review", "Assessment",
            "News and Events", "Socities", "Logout"};
    int ICONS[] = {R.drawable.ic_home, R.drawable.ic_chat, R.drawable.ic_notes, R.drawable.ic_review,
            R.drawable.ic_assessment, R.drawable.ic_calendar, R.drawable.ic_socities, R.drawable.ic_logout};

    String NAME = "Rachit Goyal";
    String EMAIL = "rachit@osahub.com";
    int PROFILE = R.drawable.profile_pic;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar drawer Toggle

    Boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drawer);
    }

    @Override
    public void setContentView(final int layoutResID) {
        DrawerLayout fullLayout = (DrawerLayout) getLayoutInflater()
                .inflate(R.layout.activity_drawer, null);

        LinearLayout actContent = (LinearLayout) fullLayout.findViewById(R.id.content);

        /* Assinging the toolbar object ot the view
    and setting the the Action bar to our toolbar
     */
        toolbar = (Toolbar) fullLayout.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) fullLayout.findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View

        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size

        mAdapter = new ToolbarAdapter(TITLES, ICONS, NAME, EMAIL, PROFILE, this);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        final GestureDetector mGestureDetector = new GestureDetector(DrawerActivity.this, new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    drawer.closeDrawers();

                    switch (recyclerView.getChildPosition(child)) {
                        case 1:
                            Intent intentHome = new Intent(getApplicationContext(), AboutUsActivity.class);
                            startActivity(intentHome);
                            finish();
                            break;
                        case 2:
                            Intent intentChat = new Intent(getApplicationContext(), ChatActivity.class);
                            startActivity(intentChat);
                            finish();
                            break;
                        case 3:
                            Intent intentNotes = new Intent(getApplicationContext(), NotesActivity.class);
                            startActivity(intentNotes);
                            finish();
                            break;
                        case 4:
                            Intent intentTeacher = new Intent(getApplicationContext(), TeacherReviewActivity.class);
                            startActivity(intentTeacher);
                            finish();
                            break;
                        case 5:
                            Intent intentAssessment = new Intent(getApplicationContext(), AssesmentActivity.class);
                            startActivity(intentAssessment);
                            finish();
                            break;
                        case 6:
                            Intent intentNews = new Intent(getApplicationContext(), NewsAndEventsActivity.class);
                            startActivity(intentNews);
                            finish();
                            break;
                        case 7:
                            Intent intentSocities = new Intent(getApplicationContext(), SocietiesActivity.class);
                            startActivity(intentSocities);
                            finish();
                            break;
                        case 8:
                            SharedPreferences.Editor edit = getSharedPreferences("meraCampus", MODE_PRIVATE).edit();
                            edit.remove("login_status");
                            edit.apply();
                            Intent intentLogout = new Intent(getApplicationContext(), LoginActivity.class);
                            startActivity(intentLogout);
                            finish();
                            break;
                    }
                    return true;
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean b) {
            }
        });


        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        drawer = (DrawerLayout) fullLayout.findViewById(R.id.drawer_layout);        // drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }
        }; // drawer Toggle Object Made
        drawer.setDrawerListener(mDrawerToggle); // drawer Listener set to the drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State

        getLayoutInflater().inflate(layoutResID, actContent, true);
        super.setContentView(fullLayout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSharedPreferences("meraCampus", MODE_PRIVATE).getString("activity_type", "navDrawer").equals("secondary")) {
                super.onBackPressed();
            } else {
                if (doubleBackToExitPressedOnce) {
                    super.onBackPressed();
                    return;
                }
                this.doubleBackToExitPressedOnce = true;
                Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleBackToExitPressedOnce = false;
                    }
                }, 2000);
            }
        }
    }
}
