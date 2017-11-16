/**
 *    @class Validation
 *    @todo cambiar nombres
 *    @description Objeto para validar valores dentro de formularios y variables.
 *    @author   Gibrán Córdoba
 *    @since   Diciembre 2016
 *    @version 0.1
 */
var Validation = function Validation() {};

/** @namespace Validation 
*   @property {object} validation - utilidades para validaciones.
**/
Validation.prototype = {
    /** @function validateEmail
    *   @memberof Validation
    *   @description Método para validar emails.
    *   @param {jQuery}  element  elemento de jQuery a validar.
    *   @returns {boolean} True o False según el Email dado.
    *   @example <caption>Validar un correo</caption>
    *   //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
    *   //Suponiendo que existe un input con email
    *   var correo = $('#id_email');
    *   if (Validation.validateEmail(correo)){..}
    *   else{..}
    */
    validateEmail: function validateEmail(element) {
        var value = element.val();
        Logger.debug('Data value to element.');
        Logger.debug(value);
        return this.validation.email(value);
    },

    /** @function validateTelefono
    *   @memberof Validation
    *   @description Método para validar teléfonos.
    *   @param {jQuery}  element  elemento de jQuery a validar.
    *   @returns {boolean} True o False según el teléfono dado.
    *   @example <caption>Validar un telefono</caption>
    *   //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
    *   //Suponiendo que existe un input con telefono
    *   var tel = $('#id_telefono');
    *   if (Validation.validateTelefono(tel)){..}
    *   else {..}
    */
    validateTelefono: function validateTelefono(element) {
        var value = element.val();
        Logger.debug('Data value to element.');
        Logger.debug(value);
        return this.validation.telefono(value);
    },

    /** @function bootstrap
    *   @memberof Validation
    *   @description Método para validar formularios.
    *   @param {object}  form  Formulario a validar.
    *   @param {object}  settings  Son las reglas de validacion del formulario.
    *   @returns {Validator} Regresa el objeto validator generado en la validation
    *   @example <caption>Validar un formulario</caption>
    *   //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
    *   //ejemplo incompleto falta determinar el parametro settings
    *   var formulario = $('#id_formulario');
    *   var settings = {
    *          rules: {
    *            // simple rule, converted to {required:true}
    *            name: "required",
    *            // compound rule
    *            email: {
    *              required: true,
    *              email: true
    *            }
    *          }
    *        };
    *   Validation.bootstrap(form,settings);
    *   
    */
    bootstrap: function bootstrap(form, settings) {
        if (typeof settings === 'undefined') settings = {};
        Logger.debug('Settings:');
        Logger.info(settings);
        var validation = form.validate(settings);

        Logger.debug('Load Validation Boostrap!');
        return validation;
    },

    /** @function loadValidateEdad
    *   @memberof Validation
    *   @description Método para evaluar una edad válida.
    *   @param {jQuery}  element  elemento de jQuery a validar.
    *   @returns {boolean} True o False según el teléfono dado.
    *   @example <caption>Validar una edad</caption>
    *   //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
    *   //suponiendo que existe un input con edad
    *   var edad = $("#id_edad");
    *   if (Validation.loadValidateEdad(edad)){..}
    *   else{..}
    *   @todo  Falta tener un nombre de funcion mas descriptivo
    */
    loadValidateEdad: function loadValidateEdad(element) {
        Logger.debug("Function loadValidateEdad...");
        var value = parseInt(element.val());
        Logger.debug("Valude to validate:");
        Logger.debug(value);
        return this.validation.edad(value);
    },

    /** @function validateDynamic
    *   @memberof Validation
    *   @todo CAMBIAR ALGUIEN QUE SEPA PARA QUÉ FUNCIONA.
    *   @description Método que agrega la leyenda de campo obligatorio en los campos vacios de un formulario
    *   @param {jQuery[]}  elements  arreglo de elementos de jQuery a validar.
    *   @returns {boolean} True si todos los campos están llenos o False si falta alguno.
    *   @example <caption>Validar...</caption>
    *   //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
    *   //ejemplo incompleto, falta la descripcion de los parametros
    *   var aInputs = [];
    *   aInputs.push($('#id_input_nombre'));
    *   aInputs.push($('#id_input_direccion'));
    *   
    *   if (Validation.validateDynamic(aInputs)){..}
    *   else {..}
    *   @todo  describir lo que hace la funcion
    *   @todo  cambiar el nombre de la funcion a uno mas descriptivo
    *   
    */
    validateDynamic: function validateDynamic(elements) {
        valid = true;
        elements.forEach(function (el) {
            Logger.debug(el);
            $.each($("." + el), function (index, val) {
                if ($(this).next('label').hasClass('error')) {
                    $(this).next('label').remove();
                }
                if ($(this).val() == "") {
                    Logger.debug('Vacio');
                    valid = false;
                    $(this).after('<label id="' + $(this).attr('name') + '-error" class="error" for="' + $(this).attr('name') + '"><span class="label label-danger"><i class="ion-android-cancel"></i> Este campo es obligatorio.</span></label>');
                }
            });
        });
        if (!valid) {
            Logger.debug('No Valido');
            return false;
        } else {
            Logger.debug('Valido');
            return true;
        }
    },

    /**
     *    @memberOf Validation 
     *    @type {object}
     *    @namespace Validation.validation
     *    
     *    @property {object} Validation.validation  - objeto para validar datos
     *    @description son utilidades para validar diferentes tipos de datos.
     *    @author   Gibrán Córdoba 
     *    @since 2016-03-04
     *    
     */

    validation: {
        /**
         * @memberof Validation.validation
         * @function edad
         * @param {Int}  edad  cadena que evaluaremos.
         * @description funcion que evalua una edad
         * @return {boolean} True si la edad esta entre 1 y 149, False sino.
         * @example <caption>Validar...</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var edad=43;
         * if (Validation.validation.edad(edad)){..}
         * else{..}
         */
        edad: function edad(_edad) {
            if (_edad > 0 && _edad < 150) {
                Logger.debug("Edad Valida:");
                return true;
            } else {
                Logger.error("Edad No Valida:");
                return false;
            }
        },
        /**
         * @memberof Validation.validation
         * @function telefono
         * @param {string}  telefono  el string al que validaremos.
         * @description funcion que evalua un telefono
         * @return {boolean} True si es un telefono valido, False sino.
         * @example <caption>Validar telefono</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var tel="2290123456";
         * if (Validation.validation.telefono(tel)){..}
         * else{..}
         */
        telefono: function telefono(_telefono) {
            var filter = /^\d{7}$/;
            var filter2 = /^\d{12}$/;
            if (filter.test(_telefono) || filter2.test(_telefono)) {
                Logger.debug("Correct Telephone");
                return true;
            } else {
                Logger.error("Invalid Telephone");
                return false;
            }
        },
        /**
         * @memberof Validation.validation
         * @function email
         * @param {String}  email  String al que evaluaremos.
         * @description funcion que evalua un correo
         * @return {boolean} True si el email es valido, False sino.
         * @example <caption>Validar email</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var email="mi_correo@es.valido";
         * if (Validation.validation.email(email)){..}
         * else{..}
         */
        email: function email(_email) {
            var filter = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            if (filter.test(_email)) {
                Logger.debug("Correct Email");
                return true;
            } else {
                Logger.error("Invalid Email");
                return false;
            }
        },
        /**
         * @memberof Validation.validation
         * @function min
         * @param {String} String a evaluar.
         * @param {Int}  min  numero minimo de caracteres en una cadena.
         * @description funcion que verifica que el string value tenga mas de min caracteres de longitud
         * @return {boolean} True Si la longitud de la cadena value es mayor a min, False sino.
         * @example <caption>Validar min</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var cadena="ejemplo";
         * var minCaracteres = 3;
         * if (Validation.validation.min(cadena,minCaracteres)){..}
         * else{..}
         */
        min: function min(value, _min) {
            if (value.length > _min) {
                Logger.debug("String mayor al minimo");
                return true;
            } else {
                Logger.error("String menor al minimo");
                return false;
            }
        },
        /**
         * @memberof Validation.validation
         * @function max
         * @param {String} value String a evaluar.
         * @param {Int}  max  numero maximo de caracteres en una cadena.
         * @description funcion que verifica que el string value tenga menos de max caracteres de longitud
         * @return {boolean} True Si la longitud de la cadena value menor a max, False sino.
         * @example <caption>Validar max</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var cadena="ejemplo";
         * var maxCaracteres = 3;
         * if (Validation.validation.max(cadena,maxCaracteres)){..}
         * else{..}
         */
        max: function max(value, _max) {
            if (value.length < _max) {
                Logger.debug("String menor al maximo");
                return true;
            } else {
                Logger.error("String mayor al maximo");
                return false;
            }
        },
        /**
         * @memberof Validation.validation
         * @function length
         * @param {String} value String evaluaremos.
         * @param {Int}  length  numero maximo de caracteres en una cadena.
         * @description funcion que verifica que el string value tenga a lo mas length caracteres
         * @return {boolean} True Si la longitud de la cadena value es menor o igual a lenght, False sino.
         * @example <caption>Validar lenght</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var cadena="ejemplo";
         * var minCaracteres = 3;
         * if (Validation.validation.length(cadena,minCaracteres)){..}
         * else{..}
         */
        length: function length(value, _length) {
            if (value.length <= _length) {
                Logger.debug("Value es menor al length");
                return true;
            } else {
                Logger.error("Value es mayor o indefinido al length");
                return false;
            }
        },
        /**
         * @memberof Validation.validation
         * @function range
         * @param {String} value String evaluaremos.
         * @param {Int}  min  numero minimo de caracteres en la cadena.
         * @param {Int}  max  numero maximo de caracteres en la cadena.
         * 
         * @description funcion que verifica que la longitud de la cadena sea mayor a min y menor a max
         * @return {boolean} True Si la longitud de la cadena value es mayor a min y menor a max, False sino.
         * @example <caption>Validar range</caption>
         * //Suponiendo que se ha cargado el objeto 'Validation' dentro del Scope en el que estamos trabajando.
         * var cadena="ejemplo";
         * var min = 5;
         * var max = 10
         * if (Validation.validation.range(cadena,min,max)){..}
         * else{..}
         */
        range: function range(value, min, max) {
            if (value.length > min) {
                if (value.length < max) {
                    Logger.debug("Esta dentro del Rango de validacion");
                    return true;
                } else {
                    Logger.error("El Valor es mayor al Maximo");
                    return false;
                }
            } else {
                Logger.error("El Valor es menor del minimo");
                return false;
            }
        }
    }
};