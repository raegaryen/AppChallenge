Coding challenge
================
![Build Status - Master](https://travis-ci.org/raegaryen/AppChallenge.svg?branch=master)

## General
There is no MVP pattern because most of the logic is implemented in the `*AdapterDelegate` classes to manage different view types. So that not all the logic is NOT in a single big Adapter.

The `MsgTransformer` converts the .JSON list into different displayable objects.

## Requirements
Your app should:

- download messages from specified endpoint. **DONE look inside ```ApiServiceImpl``` class**
- display messages in scrollable list on screen. **DONE**
- give user a way to delete specific message, preferably by swiping, but long press is also acceptable. 
**DONE swipe is left or right**


## Suggestions for bonus points

- lazy loading, client doesn't need to load all available messages on start, notice that messages are sorted, and more pages can be fetched when user scrolls through the list. 

> You could detect that user is scrolling and getting close to the end of the list, this could trigger fetching of more messages.

**Done , I used `SwipeRefreshLayoutBottom`, but the fetching is triggered only the RecyclerView reaches the end of the list not before**

- caching, it would be good if the app was able to display previously fetched messages even when it is restarted without
network connection, it could also remember what entries were previously deleted.
**NOT DONE**
- inline images, some messages contain a link to an image, it owuld be nice to display those images inline
**DONE , in the current repo there is no messages containing an image url . In ```ApiServiceImpl``` , there is another endpoint in the comment**
