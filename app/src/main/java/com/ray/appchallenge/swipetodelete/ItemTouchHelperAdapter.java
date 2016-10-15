package com.ray.appchallenge.swipetodelete;

/**
 * @author  Raymond Chenon
 *
 *          <p>https://medium.com/@ipaulpro/drag-and-swipe-with-recyclerview-b9456d2b1aaf#.u0gdmqlp6
 */

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
