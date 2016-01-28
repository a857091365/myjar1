package com.xjwww.www.myjar.activity;

import android.os.Bundle;
import android.os.MemoryFile;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.xjwww.www.myjar.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.aaaa)
    TextView aaaa;
    @Bind(R.id.aaaa1)
    TextView aaaa1;
    @Bind(R.id.aaaa2)
    TextView aaaa2;
    @Bind(R.id.aaaa3)
    TextView aaaa3;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        aaaa3.setText("对的3");
        aaaa1.setText("对的1");
        aaaa2.setText("对的2");
        aaaa.setText("对的");

        List lis = new ArrayList();
        for (int i = 0; i < lis.size(); i++) {


        }

    }
    public int firstMissingPositive(int[] nums) {


        List list = new ArrayList();

        int s=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0&&nums[i]<nums[i+1]){
                s = i;
                if(nums[i+1]-nums[i]>1){

                }
            }
        }

        return 1;
    }

}
