<%--
  Created by IntelliJ IDEA.
  User: Ace
  Date: 8/05/2016
  Time: 11:31
--%>

<%@ page import="petwiz_project.Person" %>
<html>
<head>
    <title>Petwiz: Mis mascotas</title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="layout" content="main" />
</head>
<body>

<main class="petwiz-font">
    <div class="row ">

        <div class="col s12 m8 l7 ">
            <div class="card-panel hoverable">
                <h5>Nombre:${name}</h5>
                <h5>Fecha Nacimiento:${bday}</h5>
                <h5>Edad:${age}</h5>
                <h5>Especie:${type}</h5>
                <h5>Genero:${genre}</h5>

                <div class="row center">
                    <a class="modal-trigger btn-floating waves-effect waves-light tooltipped" data-position="bottom" data-delay="50" data-tooltip="Borrar" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" href="${createLink(controller: "person", action: "delete", params:['id':"${id}"])}">
                        <i class="material-icons">delete</i>
                    </a>
                    <a class="modal-trigger btn-floating waves-effect waves-light tooltipped" data-position="bottom" data-delay="50" data-tooltip="Editar" href=${"#updatePet"}  >
                        <i class="material-icons">edit</i>
                    </a>
                </div>

            </div>
        </div>

        <div class="col s12 m4 l5 ">

            <div class="row center">
                <div class="petwiz-image-pet yeih ">
                    <image src="${createLink(controller: 'person', action: 'petImageHandler', id: name)}" class="crop"/>
                </div>
            </div>

        </div>

        <div class="col l6 m6 m12">
            <div id="updatePet" class="modal small">
                <div class="modal-content font-teal">
                    <g:form controller="person" action="updatePet">
                        <div class="input-field  col s12 m12 l12">
                            <input id="pet_id2" type="hidden" class="validate "  value="${id}" name="id2" >
                        </div>
                        <div class="row">
                            <div class="input-field col s12 m12 l12">
                                <input id="pet_name2" type="text" class="validate"   value="${name}" name="name2" >
                                <label for="pet_name2" >Nombre de Mascota</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12  m12 l12">
                                <input id="pet_type2" type="text" class="validate" value="${type}" name="typePet2">
                                <label for="pet_type2">Especie</label>
                            </div>
                        </div>

                        <div class="row">
                            <div class="input-field col s5 m8 l5 center">
                                <input type="date" class="datepicker" name="ag2" id="pet_age2">
                                <label for="date"><i class="material-icons font-teal" style="padding-left: 50px;" ></i></label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12 m12 l12">
                                <div class="input-field col s12 m12 l12">
                                    <select id="genre2" name="genre2">
                                        <option class="" value="" disabled selected>Escoja el genero</option>
                                        <option value="Macho" data-icon="/PetWiz/assets/masc.png" class="circle">Macho</option>
                                        <option value="Hembra" data-icon="/PetWiz/assets/Femenino.png" class="circle">Hembra</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <button class="btn modal-action modal-close waves-effect waves-grey petwiz-teal" name="submit" >Actualizar datos
                            <i class="material-icons right">send</i>
                        </button>
                    </g:form>
                </div>
            </div>
        </div>
    </div>
</main>

</body>
</html>