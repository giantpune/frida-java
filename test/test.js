var Object = Java.use('java.lang.Object');
var obv = Java.registerClass({
  name: 'obv',
  implements: [Object],
  methods: {
    getName: function () {
      return 'Banana';
    },
  }
});