package com.artifex.mupdfdemo;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class MuPDFReflowAdapter extends BaseAdapter {
	private final Context mContext;
	private final MuPDFCore mCore;
	private int viewMode;
	public MuPDFReflowAdapter(Context c, MuPDFCore core, int mode) {
		mContext = c;
		mCore = core;
		viewMode = mode;
	}

	public int getCount() {
		return mCore.countPages();
	}

	public Object getItem(int arg0) {
		return null;
	}

	public long getItemId(int arg0) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		final MuPDFReflowView reflowView;
		if (convertView == null) {
			reflowView = new MuPDFReflowView(mContext, mCore, new Point(parent.getWidth(), parent.getHeight()), viewMode);
		} else {
			reflowView = (MuPDFReflowView) convertView;
		}
		//reflowView.setViewMode(viewMode);
		reflowView.setPage(position, new PointF());

		return reflowView;
	}
}
