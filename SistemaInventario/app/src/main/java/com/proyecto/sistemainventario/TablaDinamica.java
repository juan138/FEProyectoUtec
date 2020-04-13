package com.proyecto.sistemainventario;

import android.content.Context;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TablaDinamica {

    private  TableLayout tableLayout;
    private Context context;
    private String[] header;
    private ArrayList<String[]> data;
    private TableRow tableRow;
    private TextView txtCell;
    private int indexCell, indexRow;


    /**
     * metodo constructor para tabla dinamica
     * @param tableLayout
     * @param context
     */
    public TablaDinamica(TableLayout tableLayout, Context context) {
        this.tableLayout=tableLayout;
        this.context=context;
    }

    /**
     * metodo para obtener encabezados de la tabla
     * @param header
     */
    public void addHeader(String[] header){
        this.header=header;
        createHeader();
    }

    /**
     * metodo para obtener el body de la tabla
     * @param data
     */
    public void addData(ArrayList<String[]> data){
        this.data=data;
        createDataTable();
    }

    private void newRow(){
        this.tableRow= new TableRow(context);
    }

    private void newCell(){
        txtCell = new TextView(context);
        txtCell.setGravity(Gravity.CENTER);
        txtCell.setTextSize(25);
    }

    private void createHeader(){
        indexCell = 0;
        newRow();
        while (indexCell<header.length){
            newCell();
            txtCell.setText(header[indexCell++]);
            tableRow.addView(txtCell,newTableRowParams());
        }
        tableLayout.addView(tableRow);
    }

    private void createDataTable(){
        try{
            String info;
            for(indexRow=1;indexRow<=header.length;indexRow++){
                newRow();
                for(indexCell=0;indexCell<header.length;indexCell++){
                    newCell();

                    String[] colums = data.get(indexRow-1);
                    info=(indexCell<colums.length)?colums[indexCell]:"";
                    txtCell.setText(info);
                    tableRow.addView(txtCell,newTableRowParams());

                }
                tableLayout.addView(tableRow);
            }
        }catch (Exception e){

        }

    }

    private TableRow.LayoutParams newTableRowParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.setMargins(1,1,1,1);
        params.weight=1;
        return  params;
    }
}
