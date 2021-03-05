# Run Server
mnvw spring-boot:run

# Understanding what pieces do what since this tutorial doesn't explain nada
* the end point - /posts returns the list of posts, and these individual posts do not reflect their attributes directly but must be built using the getters and setters.
* using the @RestResource annotation to modify an endpoint - will destroy the original

# Questions (doesn't explain why they make you do things)
* how does this end point know to get the postRepo object created in the DatabaseLoader class?
* is there even a db? is it set up by spring-boot? maven? and DatabaseLoader is a keyword class sort of deal?
* how do any of these end points get created???? posts/search/(method in postrepo interface)
* using the @RestResource annotation - what does the parameter rel do? (no explanation, looking at interface directly, no comments or java docs)
