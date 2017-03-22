package com.example.asus.listview_custom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Employee>arrEmployee = new ArrayList<Employee>();
    MyArrayAdapter adapter =null;
    ListView lvNhanVien=null;
    Button btnNhap;
    ImageButton btnRemoveAll;
    EditText txtMa, txtTen;
    RadioGroup sexGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNhap = (Button) findViewById(R.id.buttonNhap);
        btnRemoveAll = (ImageButton) findViewById(R.id.imageButtonDelete);
        txtMa = (EditText) findViewById(R.id.editTextMa);
        txtTen = (EditText) findViewById(R.id.editTextTen);
        sexGroup =(RadioGroup) findViewById(R.id.sexGroup);
        lvNhanVien = (ListView) findViewById(R.id.listViewNhanVien);
        arrEmployee = new ArrayList<Employee>();
        adapter = new MyArrayAdapter(this,
                R.layout.my_item_layout,
                arrEmployee);
        lvNhanVien.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xulyNhap();
            }
        });
        btnRemoveAll.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                xulyXoa();
            }
        });
    }

    private void xulyNhap() {
        String ma = txtMa.getText().toString();
        String ten = txtTen.getText().toString();
        boolean gioitinh = false;
                if(sexGroup.getCheckedRadioButtonId()==R.id.radioButtonNu)
                    gioitinh=true;
        // tạo 1 nv
        Employee emp = new Employee();
        emp.setID(ma);
        emp.setName(ten);
        emp.setSex(gioitinh);
        // đưa vào ds
        arrEmployee.add(emp);
        //Cập nhật giao diện
        adapter.notifyDataSetChanged();
        // reset
        txtMa.setText("");
        txtTen.setText("");
        txtMa.requestFocus();
    }

    private void xulyXoa() {
        for(int i= lvNhanVien.getChildCount()-1;i>=0;i--)
        {
            View v = lvNhanVien.getChildAt(i);// lấy nv thứ i
            CheckBox chk=(CheckBox) v.findViewById(R.id.chkitem);
            if(chk.isChecked())
            {
                arrEmployee.remove(i);
            }
        }
        adapter.notifyDataSetChanged();
    }
}
