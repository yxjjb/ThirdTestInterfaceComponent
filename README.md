# 实验3_Android界面组件

# 一.
### result
![图片](https://github.com/yxjjb/ThirdTestInterfaceComponent/blob//main/picture/1.png)

## List<Map<String, Object>> lists = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < names.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("text", names[i]);
            map.put("image", images[i]);
            lists.add(map);

        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, lists, R.layout.layout,
                new String[]{"text", "image"}, new int[]{R.id.text, R.id.image});

        ListView list = findViewById(R.id.mylist);
        list.setAdapter(simpleAdapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toastCenter = Toast.makeText(getApplicationContext(), names[position], Toast.LENGTH_SHORT);
                toastCenter.show();
            }

## 点击变色 <item android:state_pressed="true">
        <color android:color="#CC5233"></color>

    </item>
    <item android:state_pressed="false">
        <color android:color="#fff"></color>

    </item>

# 二.
### result
![图片](https://github.com/yxjjb/ThirdTestInterfaceComponent/blob//main/picture/2.png)

## 

# 三.
### result
![图片](https://github.com/yxjjb/ThirdTestInterfaceComponent/blob//main/picture/3.1.png)
![图片](https://github.com/yxjjb/ThirdTestInterfaceComponent/blob//main/picture/3.2.png)
![图片](https://github.com/yxjjb/ThirdTestInterfaceComponent/blob//main/picture/3.3.png)

## public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.my_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.font_10:
                textView.setTextSize(10);
                break;
            case R.id.font_16:
                textView.setTextSize(16);
                break;
            case R.id.font_20:
                textView.setTextSize(20);
            case R.id.plain_item:
                Toast.makeText(this,"点击了普通菜单项",Toast.LENGTH_LONG);
                break;
            case R.id.red_font:
                textView.setTextColor(Color.RED);
                break;
            case R.id.black_font:
                textView.setTextColor(Color.BLACK);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

# 四.
### result
![图片](https://github.com/yxjjb/ThirdTestInterfaceComponent/blob//main/picture/4.png)

## private ListView textView = null;
    private String data[] = {"One","Two","Three","Four","Five","Six","Seven"};
    private int chooseData[] = {0,0,0,0,0,0,0};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_mode_test3);

        textView = (ListView) findViewById(R.id.test3_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        textView.setAdapter(adapter);
        this.registerForContextMenu(textView);

        textView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView context = (TextView) view.findViewById(android.R.id.text1);
                Toast.makeText(actionModeTest3.this, context.getText().toString(), Toast.LENGTH_SHORT).show();

                chooseData[i] = 1 - chooseData[i];
                if (chooseData[i] == 1) {
                    context.setBackgroundColor(Color.parseColor("#00CCFF"));
                } else {
                    context.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                int chooseMount = 0;
                for( int j = 0; j < chooseData.length; j++) {
                    if( chooseData[j] == 1 ) chooseMount++;
                }
                setTitle("Selected" + chooseMount);
                if (chooseMount == 0) setTitle("unSelected");
            }
        });
    }
