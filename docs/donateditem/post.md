# Create a Donated Item

Create a Donated Item for the active User can access and with what permission level.
Includes their own Account if they have one.

**URL** : `/edoe/donateditem`

**Method** : `POST`

**Auth required** : YES

**Permissions required** : None

**Data constraints** : `{}`

## Success Responses

**Condition** : None.

**Code** : `202 ACCEPTED`

**Content** : `{[]}`

### OR

**Condition** : User can see one or more Donated Item .

**Code** : `200 OK`

**Content** : In this example, the User can see one Donated Item as AccountAdmin
`AA`, Viewer `VV`, and Owner `OO` - in that order:

19 - blusa, tags: [roupa, camiseta], quantidade: 15, doador: Elizabeth Ashe/70513372911
