package linkersoft.blackpanther.colortextview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.Html;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.widget.TextView;

import java.io.IOException;
import java.util.Locale;



public class ColorTextView extends TextView {


    public ColorTextView(Context context){
        super(context);
    }
    String textstatement, colorstatement, pureString;
    public ColorTextView(Context context, AttributeSet attrs) throws IOException {
        super(context, attrs);
        in(context, attrs);
        if(!textstatement.contains("null"))setText(textstatement, colorstatement);
    }
    public ColorTextView(Context context, AttributeSet attrs, int defStyleAttr) throws IOException {
        super(context, attrs, defStyleAttr);
        in(context, attrs);
        if(!textstatement.contains("null"))setText(textstatement, colorstatement);
    }
    String ColoredhtmlString(String text, String color){
        return "<font color="+color+">"+text+"</font>";
    }
    String boldhtmlString(String text){
        return "<b>"+text+"</b>";
    }
    public void setText(String textstatement, String colorstatement){
        String words[]=textstatement.split("#"), colors[]=colorstatement.split(":"), coloredSentence="",wrd;
        for(int i=0; i<words.length; i++){
            wrd=ColoredhtmlString(words[i], colors[i]);
            if(wrd.contains("}")) wrd=wrd.replace('}', '#');
            if(wrd.contains("%")) wrd=boldhtmlString(wrd.split("%")[0]);
            coloredSentence+=wrd;
        }setText(Html.fromHtml(coloredSentence));
        pureString=""+getText();

    }
    public void resetColors(String colorstatement){
        setText(textstatement,colorstatement);
    }
    void in(Context context, AttributeSet attrs){
        TypedArray _attrs=context.getTheme().obtainStyledAttributes(attrs, R.styleable.ColorTextView, 0, 0);
        try{
            textstatement=_attrs.getString(R.styleable.ColorTextView_Sentence);
            colorstatement=_attrs.getString(R.styleable.ColorTextView_Colours);
        }finally{ _attrs.recycle();}
    }

    CharSequence inTxt=null;
    public void Highlight(String highlightString, int highlightColor){
        if(highlightString!=null&&!TextUtils.isEmpty(highlightString)){
            String str = ("" + getText()).toLowerCase(Locale.getDefault());
            highlightString = highlightString.toLowerCase(Locale.getDefault());
            if (str.contains(highlightString)) {
                int startPos = str.indexOf(highlightString);
                int endPos = startPos + highlightString.length();
                Spannable spanString = Spannable.Factory.getInstance().newSpannable(inTxt = getText());
                spanString.setSpan(new ForegroundColorSpan(highlightColor), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                setText(spanString);
            } else if (inTxt != null) setText(inTxt);
        }
    }
    public void unHighlight(){
        Highlight("", Color.BLACK);
    }



}
