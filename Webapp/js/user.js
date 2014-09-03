/**
 * user.js
 */
  $(function () {
	//var data = {"userpermissions":[],"UserID":"","InputDate":"","IsValid":0,"UpdateDate":"","UserNameFirst":"","UserNameLast":""};
    //var model = new UsersModel(data);
    var viewModel = new UsersViewModel();

    ko.applyBindings(viewModel);
    viewModel.unitsearch();
    console.log("hoge");

});