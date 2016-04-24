package petwiz

import petwiz_project.Service

class DispServTagLib {
    //static defaultEncodeAs = [taglib:'html']
    static namespace = "petwiz"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def showServ = { attrs ->
        def service = attrs.service
        def edit = attrs.edit

        out << "<div class=\"col s12 m6 l4\">"
        out << "<div class=\"card hoverable\">"
        out << "<div class=\"card-image yeih waves-effect waves-block waves-light\">"
        out << "<img class=\"activator crop\" src=\"${createLink(controller: 'service', action: 'imageHandler', id: service.name)}\"/>"
        out << "</div>"
        out << "<div class=\"card-content\">"
        out << "<div class=\"row center\"><span class=\"petwiz-font small-text activator\">${service.name}</span></div>"
        if (edit) {
            out << "<div class=\"fixed-action-btn petwiz horizontal\" style=\"padding-left:170px \">"
            out << "<a class=\"btn-floating btn-large petwiz-blue\">"
            out << "<i class=\"large material-icons\">pets</i>"
            out << "</a>"
            out << "<ul>"
            out << "<li class=\"petwiz\"><a value=\"${message(code: 'default.button.delete.label', default: 'Delete')}\", onclick=\"return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');\", href=\"${createLink(controller: "service", action: "delete", params: ['name': service?.name])}\", class=\"btn-floating activator\"><i class=\"material-icons\">delete</i></a></li>"
            out << "<li class=\"petwiz\"><a href=\"#edit\" class=\"btn-floating\"><i class=\"material-icons\">edit</i></a></li>"
            out << "</ul>"
            out << "</div>"

            out << "<div id=\"edit\" class=\"modal small\">"
            out << "<g:form controller=\"service\" action=\"updateService\" enctype=\"multipart/form-data\">"
            out << "<div class=\"row\">"
            out << "<br><br>"
            out << "<div class=\"input-field col s12 m12 l12\">"
            out << "<g:field type=\"text\" id=\"serv_name\" value=\"${service.name}\" class=\"validate\" name=\"updname\"/>"
            out << "<label for=\"serv_name\" >Nombre de Servicio</label>"
            out << "	</div>"
            out << "</div>"
            out << "<div class=\"row\">"
            out << "<div class=\"input-field col s12 m12 l12\">"
            out <<		"<g:field id=\"serv_address\" type=\"text\" class=\"validate\" name=\"updaddress\" value=\"${service.address}\" />"
            out << "<label for=\"serv_address\" >Dirección</label> </div> </div>"
            out << "<div class=\"row\">	<div class=\"input-field col s12  m12 l12\">"
            out <<	"<g:field id=\"serv_tel\" type=\"number\" class=\"validate\" name=\"updphone\" value=\"${service.phone}\"/>"
            out << "<label for=\"serv_tel\">Teléfono</label></div></div>"
            out << "<div class=\"row\"><div class=\"input-field col s12 m12 l12\">"
            out << "<g:field id=\"serv_desc\" type=\"text\" class=\"validate\" name=\"upddescription\" valie=\"${service.description}\" />"
            out << "<label for=\"serv_desc\" >Descripción</label></div></div>"
            out << "<div class=\"row\">	<div class=\"input-field col s12 m12 l12\">"
            out << "<g:field id=\"serv_web\" type=\"text\" class=\"validate\" name=\"updpagWeb\"/>"
            out << "<label for=\"serv_web\" >Página Web</label></div></div>"
            out << "<div class=\"row\">"
            out << "<div class=\"input-field col s12 m12 l12\">"
            out << "<g:field id=\"serv_coord_x\" type=\"number\" class=\"validate\" name=\"updcoordenate_x\" value=\"${service.coordenate_x}\"/>"
            out << "<label for=\"serv_coord_x\" >Coordenada en X</label></div></div>"
            out << "<div class=\"row\">"
            out << "<div class=\"input-field col s12 m12 l12\">"
            out << "<g:field id=\"serv_coord_y\" type=\"number\" class=\"validate\" name=\"updcoordenate_y\" value=\"${service.coordenate_y}\"/>"
            out << "<label for=\"serv_coord_y\" >Coordenada en Y </label></div></div>"
            out << "<div class=\"row\"><div class=\"input-field col s12 m12 l12\">"
            out << "<label for=\"imagen\" >Imagen </label><br><br>"
            out << "<g:field id=\"imagen\" type=\"file\" class=\"validate\" name=\"updavatar\" /></div></div>"
            out << "<g:actionSubmit controller =\"service\" value=\"Actualizar Servicio\" action=\"update\" class=\"material-icons right btn modal-action modal-close waves-effect waves-grey petwiz-teal\"/>"
            out << "</g:form></div>"
        }
        out << "</div>"
        out << "<div class=\"card-reveal petwiz-grey\">"
        out << "<span class=\"card-title  petwiz-blue-text\">${service.name}<i class=\"material-icons right\">close</i></span>"
        out << "<p class=\" petwiz-blue-text\">"
        out << "<li><b>Descripción:</b></li>" +
                " ${service.description}"
        out << "<li><b>Dirección:</b> </li>" +
                " ${service.address}"
        out << "<li><b>Télefono:</b></li>" +
                " ${service.phone}"
        out << "<g:if test=\"${!service.webpage}\">"
        out << "<li><a href=\"${createLink(controller: "service", action: "visitServicePage", params: ['redir': service?.webpage])}\" target:\"_blank\">Página Web</a> </li>"
        out << "</g:if>"
        out << "</p>"
        out << "</div>"
        out << "</div>"
        out << "</div>"

    }
}
