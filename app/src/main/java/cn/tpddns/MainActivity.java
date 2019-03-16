package cn.tpddns;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

public class MainActivity extends AppCompatActivity {
//    private BottomNavigationBar bottomNavigationBar;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initbottomNavigationBar();
//
//
//    }
//
//    private void initbottomNavigationBar() {
//        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
//
//        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
//        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
//
//        bottomNavigationBar //值得一提，模式跟背景的设置都要在添加tab前面，不然不会有效果。
//                .setActiveColor(R.color.colorPrimary)//选中颜色 图标和文字
//                .setInActiveColor("#8e8e8e")//默认未选择颜色
//                .setBarBackgroundColor("#ECECEC");//默认背景色
//
//        bottomNavigationBar
//                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "Like"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "Home"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "Music"))
//                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "TV"))
//
////                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp,"Like").setActiveColor().setInActiveColor())
////                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp,"Home").setActiveColor().setInActiveColor())
////                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp,"Music").setActiveColor().setInActiveColor())
////                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp,"TV").setActiveColor().setInActiveColor())
//                .setFirstSelectedPosition(1)//设置默认选择的按钮
//                .initialise();//所有的设置需在调用该方法前完成
//
//
//        bottomNavigationBar //设置lab点击事件
//                .setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
//                    @Override
//                    public void onTabSelected(int position) {
//                        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//                        switch (position) {
//
//                            case 0:
//                                Toast.makeText(MainActivity.this, "竟让有这种操作！", Toast.LENGTH_SHORT).show();
//                                FragmentZore likeFragment = new FragmentZore();
//                                transaction.add(R.id.main_container,likeFragment);
//                                break;
//                            case 1:
//                                Toast.makeText(MainActivity.this, "真的有这种操作！", Toast.LENGTH_SHORT).show();
//                                FragmentOne homeFragment = new FragmentOne();
//                                transaction.add(R.id.main_container,homeFragment);
//                                break;
//                            case 2:
//                                Toast.makeText(MainActivity.this, "这是假的操作！", Toast.LENGTH_SHORT).show();
//
//                                break;
//                            case 3:
//                                Toast.makeText(MainActivity.this, "我有一句吗卖批不知当讲不当讲！", Toast.LENGTH_SHORT).show();
//
//                                break;
//
//                        }
//                    }
//
//                    @Override
//                    public void onTabUnselected(int position) {
//
//                    }
//
//                    @Override
//                    public void onTabReselected(int position) {
//
//                    }
//                });
//
//
//    }
//}


    //    private ChatmesFragment mChatmesFragment;
//    private NewLoanFragment mNewLoanFragment;
//    private SettingFragment mSettingFragment;
//    private SystemFragment mSystemFragment;
    private FragmentZore mChatmesFragment;
    private FragmentOne mNewLoanFragment;
    private FragmentTwo mSettingFragment;
    private FragmentThree mSystemFragment;
    private FragmentFive mFiveFragment;
    private TextView abc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setDefaultFragment();

        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        abc=findViewById(R.id.textView);
        bottomNavigationBar.setTabSelectedListener(tabSelectedListener);

        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_favorite_white_24dp, "chatmes").setActiveColorResource(R.color.blue))
                .addItem(new BottomNavigationItem(R.drawable.ic_home_white_24dp, "newLoan").setActiveColorResource(R.color.black))
                .addItem(new BottomNavigationItem(R.drawable.ic_music_note_white_24dp, "setting").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.ic_tv_white_24dp, "systems").setActiveColorResource(R.color.pink))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE)
                .setFirstSelectedPosition(0)
                //注意，所有的设置都要在该方法之前完成
                .initialise();

    }

    private void setDefaultFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        mChatmesFragment = new FragmentZore();
        transaction.replace(R.id.main_container, mChatmesFragment);
        transaction.commit();
    }

    private BottomNavigationBar.OnTabSelectedListener tabSelectedListener = new BottomNavigationBar.OnTabSelectedListener() {
        @Override
        public void onTabSelected(int position) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
         // hideFragment(transaction);

            switch (position) {
                case 0:
                    if (mChatmesFragment == null) {
                        mChatmesFragment = new FragmentZore();

                    } else
                        abc.setText("");
                        transaction.replace(R.id.main_container, mChatmesFragment);

                    break;
                case 1:
                    if (mNewLoanFragment == null) {
                        mNewLoanFragment = new FragmentOne();

                    }
                    abc.setText("");
                    transaction.replace(R.id.main_container, mNewLoanFragment);
                    //transaction.show(mNewLoanFragment);
                    break;
                case 2:
                    if (mSettingFragment == null) {
                        mSettingFragment = new FragmentTwo();
                        transaction.add(R.id.main_container, mSettingFragment);
                    }
                    abc.setText("");
                    transaction.replace(R.id.main_container, mSettingFragment);

                    break;
                case 3:
                    if (mSystemFragment == null) {
                        mSystemFragment = new FragmentThree();

                    }
                    abc.setText("");
                    transaction.replace(R.id.main_container, mSystemFragment);

                    break;
            }
            transaction.commit();
        }

        @Override
        public void onTabUnselected(int position) {

        }

        @Override
        public void onTabReselected(int position) {

        }
    };

    private void hideFragment(FragmentTransaction transaction) {
        if (mChatmesFragment != null)
            transaction.hide(mChatmesFragment);
        if (mNewLoanFragment != null)
            transaction.hide(mNewLoanFragment);
        if (mSettingFragment != null)
            transaction.hide(mSettingFragment);
        if (mSystemFragment != null)
            transaction.hide(mSystemFragment);

    }
}