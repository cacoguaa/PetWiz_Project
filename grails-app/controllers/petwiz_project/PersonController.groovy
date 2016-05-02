package petwiz_project

import grails.transaction.Transactional
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.commons.CommonsMultipartFile

@Transactional(readOnly = true)
class PersonController {

    static allowedMethods = [addPet: "POST", updatePet: "POST", deletePet: "DELETE"]
    private static final okcontents = ['image/png', 'image/jpeg', 'image/gif']

    def home() {
        render(controller: 'person', view: '/person/home');
    }

    def mypets() {
        render(controller: 'person', view: '/person/mypets');

    }

    def services() {
        render(controller: 'person', view: '/person/services');
    }

    def myevents() {
        render(controller: 'person', view: '/person/myevents');
    }
    def myfriends() {
        render(controller: 'person', view: '/person/myfriends');
    }

    def muestra() {

        //def name = params.name
        //def kind = params.kind
        //def age = params.age
        //def genre = params.genre

        //[name:name,kind:kind,age:age, genre:genre]

    }


    @Transactional
    def addPet(Pet pet) {

        def user = Person.findByUsername(session["user"])


        def typePet = (params.typePet).toString()
        def name = (params.name).toString()
        def genre = (params.genre).toString()
        def age = (params.age).toInteger()
        def id = (params.id).toLong()
        def photo = params.photo
        def photoType = params.photoType


        println("name pet: " + name)
        println("type pet: " + typePet)
        println("age: " + age)
        println("genre: " + genre)
        println("id: " + id)
        println("photo: " + photo)

        //Obtener la imagen
        MultipartHttpServletRequest mpr = (MultipartHttpServletRequest) request;
        CommonsMultipartFile f = (CommonsMultipartFile) mpr.getFile("avatar")
        if (!okcontents.contains(f.getContentType())) {
            flash.message = "El avatar debe tener alguno de los siguientes formatos: ${okcontents}"

        }
        print f


        print "pet not saved"
        if (user) {

            print "Current user: " + user.username

            user.save()


            //def pet
            pet = new Pet(type: typePet, name: name, genre: genre, age: age, photo:photo, photoType: photoType )
            pet.pet_type = typePet
            pet.pet_name = name
            pet.pet_genre = genre
            pet.pet_age = age
            pet.photo = f.bytes
            pet.photoType = f.contentType
            pet.save()

            user.addToPets(pet)
            user.save(failOnError: true, flush: true)
        }

        print "pet saved"

        def list = user.pets//Para mirar las mascotas que tiene un usuario
        list.each {
            def listPetName = it.pet_name

            print "PET ADDED: " + listPetName

        }
        print "Number of pets: " + list.size()
        print "First pet: " + list.getAt(0).pet_name


        render(controller: 'person', view: '/person/mypets');

    }

    @Transactional
    def delete() {
        def user = Person.findByUsername(session["user"])
        def pet=Pet.get(params.id)
        print pet.pet_name
        pet.delete(flush: true)
        print pet.pet_name
        def list = user.pets//Para mirar las mascotas que tiene un usuario
        list.each {
            def listPetName = it.pet_name

            print "CURRENT PET: " + listPetName

        }
        print "Number of pets: " + list.size()
        /*   def userD = Person.findByUsername(session["user"])
           def currentPet = userD.pets[0]



           print "Select current pet: " + currentPet.pet_name

           print "Deleting pet..."
           pet = Pet.get(params.id)
           //def pet = Pet.get(params.getIdentifier())
           //pet.getId()




           print "Pet deleted"

           redirect(controller: 'person', view: '/person/home');*/
        redirect(action: 'mypets');
    }

    @Transactional
    def updatePet(Pet tmp) {
        print "shit"
        def user = Person.findByUsername(session["user"])
        def typePet = (params.typePet2).toString()
        def name = (params.name2).toString()
        def genre = (params.genre2).toString()
        def age = (params.age2).toInteger()
        def id = (params.id2).toLong()

        if (user){

            tmp = Pet.get(id)
            tmp.pet_type = typePet
            tmp.pet_name = name
            tmp.pet_genre = genre
            tmp.pet_age = age
            tmp.save(flush: true)

            render(controller: 'person', view: '/person/mypets');

        }else{
        	redirect(controller:'user',action:'viewHome')
        }

    }

    def petImageHandler() {
        def name = params.id.toString()
        def pet = Pet.findByPet_name(name)

        if (!pet.photo || !pet.photoType) {
            response.sendError(404)
            return
        }
        response.contentType = pet.photoType
        response.contentLength = pet.photo.size()
        OutputStream out = response.outputStream
        out.write(pet.photo)
        out.close()

        println "Current name: " + name
        println "ImgName: "+ pet.photo.getProperties()
        println "ImgType: "+ pet.photoType
    }
}

