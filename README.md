# RasaConnector

This is a sample project to connect Rasa core


Exposed Endpoints :-

GET - http://<ip add:port>/core/message/<message>
  
Sample Request and Response :
1. http://localhost:8980/core/message/hi

response :-
[
  {
    "recepient_id":"default",
    "text":"Hey,How can I help you ?"
  }
]
