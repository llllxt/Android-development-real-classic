package com.example.android.snake;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;


//View ���֣��������� һ�� ��Ƭ���� ��icons���������ɻ��ƵĶ���  
public class TileView extends View {

    /**
     * Parameters controlling the size of the tiles and their range within view.
     * Width/Height are in pixels, and Drawables will be scaled to fit to these
     * dimensions. X/Y Tile Counts are the number of tiles that will be drawn.
     */

    protected static int mTileSize; //ÿ��tile�ı߳�����������

    protected static int mXTileCount; //��Ļ�������ɵ� X�����Ϸ����������
    protected static int mYTileCount;//��Ļ�������ɵ� Y�����Ϸ����������

    private static int mXOffset; //ԭ�����꣬��pixel�ơ�
    private static int mYOffset;


    /**
     * �洢�Ų�ͬ�����bitmapͼ��ͨ��resetTiles��loadTile������Ϸ�еķ�����ص�������顣
     * �������Ϊ ש���ֵ�
     */
    private Bitmap[] mTileArray;    

    /**
     * A two-dimensional array of integers in which the number represents the
     * index of the tile that should be drawn at that locations
     * �洢����������ÿ��tileλ��Ӧ�û��Ƶ�tile��
     * �ɿ���������ֱ�Ӳ����Ļ�����
     * ͨ��setTile��clearTile ����ͼ����ʾ���޸Ĳ����� 
     * 
     */
    private int[][] mTileGrid; 

    //���ʣ�canvas��ͼ�λ��ƣ���Ҫ����Paintʵ�֡�
    private final Paint mPaint = new Paint();

    
   public TileView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        //ʹ��TypedArray����ȡ��attrs.xml��ΪTileView�����������tileSize ��
            //�ο��� http://weizhulin.blog.51cto.com/1556324/311453
        ////��÷��������
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
      //���R.styleable.TileView_tileSize,ȱʡֵΪ12
        mTileSize = a.getInt(R.styleable.TileView_tileSize, 12);
      //������ǰʹ�ù��ķ�����Լ���ʹ��TypedArray��һ��Ҫʹ�������
        a.recycle();
    }

    public TileView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TileView);
        mTileSize = a.getInt(R.styleable.TileView_tileSize, 12);
        a.recycle();
    }

    
    
    /**
     * Rests the internal array of Bitmaps used for drawing tiles, and
     * sets the maximum index of tiles to be inserted
     * ��������mTileArray������Ϸ��ʼ��ʱ��ʹ�á�
     * �����ש���ֵ�
     * @param tilecount
     */
    public void resetTiles(int tilecount) {
    	mTileArray = new Bitmap[tilecount];
    }

    
    /*
     * ���ı���Ļ��С�ߴ�ʱ��ͬʱ�޸�tile����ؼ���ָ�ꡣ
     */
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    	//Math.floor������һ����ӽ���������������ֵС�ڻ���������������
    	// ����X����Ƭ����  
        mXTileCount = (int) Math.floor(w / mTileSize);
        mYTileCount = (int) Math.floor(h / mTileSize);

        //mXOffset mYOffset�ǻ�ͼ��������ꡣ  ������2��ȥ����,��ʱû����Ӱ��
        mXOffset = ((w - (mTileSize * mXTileCount)) / 2);
        mYOffset = ((h - (mTileSize * mYTileCount)) / 2);

        mTileGrid = new int[mXTileCount][mYTileCount];
        clearTiles();
    }

    
    /**
     * Function to set the specified Drawable as the tile for a particular
     * integer key.
     * ���ؾ����ש��ͼƬ �� ש���ֵ䡣
     * ������Ӧ��ש���ͼƬ ��Ӧ�ļ��ص� mTileArray������
     * @param key
     * @param tile
     */
    public void loadTile(int key, Drawable tile) {
        //��������һ�� Drawable �� bitmap ��ת���������ⲿ����ʹ�õ�ʱ����ֱ�Ӷ�ȡ��Դ�ļ��е�ͼƬ��
    	//��drawable��ʽ�������ǵ�������bitmap��ʽ���������յĻ��ơ����ԣ���Ҫ����һ�ε� bitmap��ת����
    	Bitmap bitmap = Bitmap.createBitmap(mTileSize, mTileSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        tile.setBounds(0, 0, mTileSize, mTileSize);
        tile.draw(canvas);
        
        mTileArray[key] = bitmap;
    }

    /**
     * Used to indicate that a particular tile (set with loadTile and referenced
     * by an integer) should be drawn at the given x/y coordinates during the
     * next invalidate/draw cycle.
     * ����Ӧ������λ�û�����Ӧ��ש��
     * �ǵ�Ŷ��mTileGrid��ʵ��������ֱ�Ӳ����Ļ�����
     * @param tileindex
     * @param x
     * @param y
     */
    public void setTile(int tileindex, int x, int y) {
        mTileGrid[x][y] = tileindex;
    }

    /**
     * Resets all tiles to 0 (empty)
     * ���ͼ����ʾ��
     * ���Ը��»��档
     * �����˻�ͼ��setTile()��
     */
    public void clearTiles() {
        for (int x = 0; x < mXTileCount; x++) {
            for (int y = 0; y < mYTileCount; y++) {
                setTile(0, x, y);
            }
        }
    }

/*
 * ������ֱ�Ӳ����Ļ������Ƶ��ֻ������ϣ�
 * @see android.view.View#onDraw(android.graphics.Canvas)
 */
    //���ǣ� View �е� onDraw(...)
    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int x = 0; x < mXTileCount; x++) {
            for (int y = 0; y < mYTileCount; y++) {
                if (mTileGrid[x][y] > 0) {
                    canvas.drawBitmap(mTileArray[mTileGrid[x][y]], 
                    		mXOffset + x * mTileSize,
                    		mYOffset + y * mTileSize,
                    		mPaint);
                }
            }
        }
    }

}