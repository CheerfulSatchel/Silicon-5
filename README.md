Upon logging in the user has to choose which role they are contributing (the person that lost an item or the person who found an item).

One list with all the items in Firebase. Each item is marked as lost or found. 

The user can view a list of lost items (based on location in later version). If a user finds an item and the item exists in the "lost" list, then they mark that item as found and they then communicate with the other user for the reward. If the user finds an item and the item does not exist in "lost" list, then they submit the a new item into the list with the appropriate info + the "found" tag. 

If a user has lost an item, they report it using the app with the appropriate information. The app then provides a list of found items that it believes matches the user's item (it also provides a list of "other" items that the user can manually navigate). If the user accepts the item, then the rewards is given to the founder. If the user declines, then the item is stored in the list as a "lost" item.



---------------------
Item attributes:

Username
Name of Item
Category of Item
Location lost (either current or manual entry)
Time lost (either current or manual entry)
Reward
Image (if not entered, generic is used in its place)
Description 
