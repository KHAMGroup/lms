// @SOURCE:/Users/matthewreyes/programming/workspace01-indigo/lms/ddllab/conf/routes
// @HASH:7f30a2f8806f63748bd1814b2a8648f4a6993868
// @DATE:Mon Sep 23 19:16:01 PDT 2013

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:25
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseEmployeeApp {
    

// @LINE:9
def employee(id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "employees/" + implicitly[PathBindable[Int]].unbind("id", id))
}
                                                

// @LINE:8
def employees(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "employees")
}
                                                

// @LINE:10
def update(id:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "employees/" + implicitly[PathBindable[Int]].unbind("id", id) + "/update")
}
                                                

// @LINE:11
def create(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "employees/new")
}
                                                

// @LINE:13
def delete(id:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "employees/" + implicitly[PathBindable[Int]].unbind("id", id) + "/delete")
}
                                                

// @LINE:12
def save(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "employees/save")
}
                                                
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:25
class ReverseAssets {
    

// @LINE:25
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          
}
                  


// @LINE:25
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.javascript {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseEmployeeApp {
    

// @LINE:9
def employee : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EmployeeApp.employee",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:8
def employees : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EmployeeApp.employees",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "employees"})
      }
   """
)
                        

// @LINE:10
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EmployeeApp.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id) + "/update"})
      }
   """
)
                        

// @LINE:11
def create : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EmployeeApp.create",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/new"})
      }
   """
)
                        

// @LINE:13
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EmployeeApp.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/" + (""" + implicitly[PathBindable[Int]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:12
def save : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.EmployeeApp.save",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "employees/save"})
      }
   """
)
                        
    
}
              

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:25
class ReverseAssets {
    

// @LINE:25
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              
}
        


// @LINE:25
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:6
package controllers.ref {

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
class ReverseEmployeeApp {
    

// @LINE:9
def employee(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EmployeeApp.employee(id), HandlerDef(this, "controllers.EmployeeApp", "employee", Seq(classOf[Int]), "GET", """""", _prefix + """employees/$id<[^/]+>""")
)
                      

// @LINE:8
def employees(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EmployeeApp.employees(), HandlerDef(this, "controllers.EmployeeApp", "employees", Seq(), "GET", """ Employees""", _prefix + """employees""")
)
                      

// @LINE:10
def update(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EmployeeApp.update(id), HandlerDef(this, "controllers.EmployeeApp", "update", Seq(classOf[Int]), "POST", """""", _prefix + """employees/$id<[^/]+>/update""")
)
                      

// @LINE:11
def create(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EmployeeApp.create(), HandlerDef(this, "controllers.EmployeeApp", "create", Seq(), "POST", """""", _prefix + """employees/new""")
)
                      

// @LINE:13
def delete(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EmployeeApp.delete(id), HandlerDef(this, "controllers.EmployeeApp", "delete", Seq(classOf[Int]), "POST", """""", _prefix + """employees/$id<[^/]+>/delete""")
)
                      

// @LINE:12
def save(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.EmployeeApp.save(), HandlerDef(this, "controllers.EmployeeApp", "save", Seq(), "POST", """""", _prefix + """employees/save""")
)
                      
    
}
                          

// @LINE:6
class ReverseApplication {
    

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:25
class ReverseAssets {
    

// @LINE:25
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          
}
                  
      