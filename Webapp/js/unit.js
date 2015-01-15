/**
 * unit.js
 */
  $(function () {
    var unitsVM = new UnitsViewModel();

    ko.applyBindings(unitsVM);
    unitsVM.listsearch();
    var usersVM = new UsersViewModel();

    ko.applyBindings(usersVM);
    usersVM.unitsearch();

});